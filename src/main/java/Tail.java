import geometrical_components.Line;
import geometrical_components.Point;
import java.awt.*;

public class Tail extends GameObject {

    private Color color = Color.black;

    public Tail(ID id, Point pos, int xSize, int ySize, Handler handler) {
        super(id, pos, xSize, ySize, handler);
    }

    public void tick() {
        super.tick();
    }

    public void render(Graphics g) {
        super.render(g);
    }
}
