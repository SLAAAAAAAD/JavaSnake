import geometrical_components.GeoMath;
import geometrical_components.Line;
import geometrical_components.Point;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;

public class Snake extends DynamicObject {

    private ArrayList<Tail> tail = new ArrayList<>();
    private int length = 800;
    protected double accel = .3;
    private double minSpeed, maxSpeed;
    protected Color color = Color.black;

    public Snake(Point pos, Handler handler) {
        super(pos, 1, 1, handler);
        speed = new Point((float) Math.random() - 1, (float) Math.random() - 1);
        minSpeed = 4;
        maxSpeed = 4;
    }

    public void tick() {
        handleMovement();
        addTail();
        selfCollisionDetection();
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(color);
        for (Tail t : tail) {
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

    private void selfCollisionDetection() {
        Line newestTailSegment = null;

        if (tail.size() > 2) {
            newestTailSegment = new Line(tail.get(tail.size() - 1).getPos(), tail.get(tail.size() - 2).getPos());
        }

        for (int i = 0; i < tail.size(); i++) {
            DynamicObject tempObject = tail.get(i);

            tempObject.tick();

            if (i < tail.size() - 3) {

                Line currentTailSegment = new Line(tail.get(i).getPos(), tail.get(i + 1).getPos());

                Point intersect = GeoMath.lineIntersect(currentTailSegment, newestTailSegment);

                if (intersect != null) {
                    System.out.println("X");
                    tail = new ArrayList<>();
                }
            }
        }
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
}
