import java.awt.*;
import java.util.ArrayList;

public class Handler {
    ArrayList<DynamicObject> objects = new ArrayList<>();
    private Camera camera;

    public Handler(Camera camera){
        this.camera = camera;
    }

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            DynamicObject tempObject = objects.get(i);

            tempObject.tick();
        }
        camera.tick();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
        for (int i = 0; i < objects.size(); i++) {
            DynamicObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public Camera getCamera(){
        return camera;
    }

    public void addObject(DynamicObject object) {
        objects.add(object);
    }

    public void removeObject(DynamicObject object) {
        objects.remove(object);
    }
}
