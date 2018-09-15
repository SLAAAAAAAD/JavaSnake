import java.awt.*;
import java.util.ArrayList;

public class Handler {
    ArrayList<GameObject> objects = new ArrayList<>();
    private Camera camera = new Camera(0,0);

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.tick();
        }
        camera.tick();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }
}
