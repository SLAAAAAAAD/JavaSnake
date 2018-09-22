import geometrical_components.Vector;
import java.awt.*;

public class Tail extends DynamicObject {

    private Color color = Color.black;

    public Tail(ID id, Vector pos, int xSize, int ySize, Handler handler) {
        super(id, pos, xSize, ySize, handler);
    }

    public void tick() {
        super.tick();
    }

    public void render(Graphics g) {
        super.render(g);
    }
}
