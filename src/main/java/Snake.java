import geometrical_components.GeoMath;
import geometrical_components.Line;
import geometrical_components.Point;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;

public class Snake extends DynamicObject {

    protected ArrayList<Tail> tail = new ArrayList<>();
    protected int length = 100;
    protected double accel = .3;
    private double minSpeed, maxSpeed;
    protected Color color = Color.black;

    public Snake(Point pos, Handler handler) {
        super(pos, 1, 1, handler);
        speed = new Point((float) Math.random() - 1, (float) Math.random() - 1);
        minSpeed = 1;
        maxSpeed = 5;
        handler.addObject(this);
    }

    public void tick() {
        handleMovement();
        addTail();
        for (int i = 0; i < tail.size(); i++) {
            Tail tempObject = tail.get(i);

            tempObject.tick();
        }
        Point p = handleCollision();
        if (p != null) {
            dead = true;
        }
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(color);
        for (DynamicObject t : tail) {
            t.render(g);
        }

        for (int i = 0; i < tail.size() - 1; i++) {
            DynamicObject tailOne = tail.get(i);
            DynamicObject tailTwo = tail.get(i + 1);

            g.drawLine((int) tailOne.xRender, (int) tailOne.yRender, (int) tailTwo.xRender, (int) tailTwo.yRender);
        }
    }

    private void handleMovement() {
        double totalSpeed = Math.hypot(speed.getX(), speed.getY());
        if (totalSpeed > maxSpeed) {
            double ratio = maxSpeed / totalSpeed;
            speed.setX(speed.getX() * ratio);
            speed.setY(speed.getY() * ratio);
        } else if (totalSpeed < minSpeed) {
            double ratio = minSpeed / totalSpeed;
            speed.setX(speed.getX() * ratio);
            speed.setY(speed.getY() * ratio);
        }
        pos.add(speed);
    }

    private void addTail() {
        tail.add(new Tail(new Point(pos.getX(), pos.getY()), handler));
        if (tail.size() > length) {
            tail.remove(0);
        }
    }

    private Point handleCollision() {
        Point self = selfCollisionDetection();
        if (self != null) {
            return self;
        }
        Point other = otherCollisionDetection();
        return other;
    }

    private Point selfCollisionDetection() {
        for (int i = 0; i < tail.size(); i++) {
            DynamicObject tempObject = tail.get(i);

            if (i < tail.size() - 3) {

                Line currentTailSegment = new Line(tail.get(i).getPos(), tail.get(i + 1).getPos());

                Point intersect = GeoMath.lineIntersect(currentTailSegment, getHead());

                if (intersect != null) {
                    return intersect;
                }
            }
        }
        return null;
    }

    private Point otherCollisionDetection() {
        ArrayList<DynamicObject> objects = handler.getObjects();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) != this) {
                ArrayList<Line> collidables = objects.get(i).getCollidables();
                for (int j = 0; j < collidables.size() - 1; j++) {
                    Point intersect = GeoMath.lineIntersect(collidables.get(j), getHead());
                    if (intersect != null) {
                        return intersect;
                    }
                }
            }
        }
        return null;
    }

    public void die() {
        dead = false;
//        System.out.println("X");
        tail = new ArrayList<>();
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }

    public Line getHead() {
        if (tail.size() > 2) {
            return new Line(tail.get(tail.size() - 1).getPos(), tail.get(tail.size() - 2).getPos());
        } else {
            return null;
        }
    }

    public ArrayList<Line> getCollidables() {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < tail.size() - 2; i++) {
            lines.add(new Line(tail.get(i).getPos(), tail.get(i + 1).getPos()));
        }
        return lines;
    }

    public Point getCenter() {
        if (tail.size() == 0) {
            return pos;
        }
        double xTotal = 0;
        double yTotal = 0;
        for (int i = 0; i < tail.size(); i++) {
            xTotal += tail.get(i).getPos().getX();
            yTotal += tail.get(i).getPos().getY();
        }
        return new Point(xTotal / tail.size(), yTotal / tail.size());
    }
}
