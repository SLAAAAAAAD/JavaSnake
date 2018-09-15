import java.awt.*;

public class Tail extends GameObject {

    private Color color = Color.black;

    public Tail(ID id, double xPos, double yPos, int xSize, int ySize, Handler handler) {
        super(id, xPos, yPos, xSize, ySize, handler);
    }

    public void tick() {
        super.tick();
    }

    public void render(Graphics g) {
        super.render(g);
    }
}
