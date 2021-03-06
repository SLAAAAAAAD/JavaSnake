import java.awt.*;
import java.util.ArrayList;

public class Handler {
    private ArrayList<DynamicObject> objects = new ArrayList<>();
    private Camera camera;

    public Handler(Camera camera) {
        this.camera = camera;
    }

    public void tick() {
        objects.forEach(obj -> obj.tick());

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).isDead()) {
                objects.get(i).die();
            }
        }

        camera.tick();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.black);
        g.fillOval((int)(-4 - camera.getPos().getX()),(int)(-4 - camera.getPos().getY()),7,7);
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public Camera getCamera() {
        return camera;
    }

    public void addObject(DynamicObject object) {
        objects.add(object);
    }

    public void removeObject(DynamicObject object) {
        objects.remove(object);
    }

    public ArrayList<DynamicObject> getObjects() {
        return objects;
    }
}
