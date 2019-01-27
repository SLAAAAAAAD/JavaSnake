import geometrical_components.GeoMath;
import geometrical_components.Line;
import geometrical_components.Point;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;

public class Player extends DynamicObject {

    private ArrayList<Tail> tail = new ArrayList<>();
    private int length = 800;
    private double accel = .2;
    private Color color = Color.black;

    boolean temp;

    public Player(ID id, Point pos, int xSize, int ySize, Handler handler) {
        super(id, pos, xSize, ySize, handler);
        speed = new Point((float) Math.random() - 1, (float) Math.random() - 1);
    }

    private void handleKeyInput() {
        if (KeyInput.keyPressMap != null) {
            Map<Integer, Boolean> keyMap = KeyInput.keyPressMap;

            if (keyMap.get(KeyEvent.VK_LEFT)) {
                speed.translateX(0 - accel);
            }
            if (keyMap.get(KeyEvent.VK_RIGHT)) {
                speed.translateX(accel);
            }
            if (keyMap.get(KeyEvent.VK_UP)) {
                speed.translateY(0 - accel);
            }
            if (keyMap.get(KeyEvent.VK_DOWN)) {
                speed.translateY(accel);
            }
        }
    }

    private void addTail() {
        tail.add(new Tail(ID.TERRAIN, new Point(pos.getX(), pos.getY()), handler));
    }

    public void tick() {

        temp = false;

        handleKeyInput();
        super.tick();
        addTail();
        if (tail.size() > length) {
            tail.remove(0);
        }

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
                    temp = true;
                }
            }
        }
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(color);
//        g.fillOval((int) xRender, (int) yRender, xSize, ySize);
        for (Tail t : tail) {
            t.render(g);
        }

        for (int i = 0; i < tail.size() - 1; i++) {
            DynamicObject tailOne = tail.get(i);
            DynamicObject tailTwo = tail.get(i + 1);

            g.drawLine((int) tailOne.xRender, (int) tailOne.yRender, (int) tailTwo.xRender, (int) tailTwo.yRender);
//            g.fillRect((int) tailOne.xRender, (int) tailOne.yRender, 3, 3);
        }

        if (temp){
            g.setColor(Color.RED);
            g.fillRect(0,0,800,800);
        }
    }
}
