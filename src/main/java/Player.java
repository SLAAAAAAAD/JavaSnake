import geometrical_components.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;

public class Player extends DynamicObject {

    private ArrayList<Tail> tail = new ArrayList<>();
    private int length = 400;

    public Player(ID id, Vector pos, int xSize, int ySize, Handler handler) {
        super(id, pos, xSize, ySize, handler);
        speed = new Vector((float) Math.random() - 1, (float) Math.random() - 1);
    }

    private void handleKeyInput() {
        if (KeyInput.keyPressMap != null) {
            Map<Integer, Boolean> keyMap = KeyInput.keyPressMap;

            if (keyMap.get(KeyEvent.VK_LEFT)) {
                speed.translateX(-0.2);
            }
            if (keyMap.get(KeyEvent.VK_RIGHT)) {
                speed.translateX(0.2);
            }
            if (keyMap.get(KeyEvent.VK_UP)) {
                speed.translateY(-0.2);
            }
            if (keyMap.get(KeyEvent.VK_DOWN)) {
                speed.translateY(0.2);
            }
        }
    }

    private void addTail() {
        tail.add(new Tail(ID.TERRAIN, new Vector(pos.getX(), pos.getY()), 0, 0, handler));
    }

    public void tick() {
        handleKeyInput();
        super.tick();
        addTail();
        if (tail.size() > length) {
            tail.remove(0);
        }
        for (int i = 0; i < tail.size(); i++) {
            DynamicObject tempObject = tail.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.black);
        g.fillOval((int) xRender, (int) yRender, xSize, ySize);
        for (Tail t : tail) {
            t.render(g);
        }
        for (int i = 0; i < tail.size() - 1; i++) {
            DynamicObject tailOne = tail.get(i);
            DynamicObject tailTwo = tail.get(i + 1);

            g.drawLine((int) tailOne.xRender, (int) tailOne.yRender, (int) tailTwo.xRender, (int) tailTwo.yRender);
        }
    }
}
