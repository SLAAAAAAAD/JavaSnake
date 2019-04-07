import geometrical_components.GeoMath;
import geometrical_components.Point;

import java.awt.*;
import java.util.ArrayList;

public class AISnake extends Snake {
    public AISnake(Point pos, Handler handler) {
        super(pos, handler);
        color = Color.red;
    }

    public void tick() {
        AIPathing();
        super.tick();
    }

    private void AIPathing() {
        ArrayList<Point> attractors = new ArrayList<>();
        for (int i = 0; i < handler.getObjects().size(); i++) {
            DynamicObject tempObj = handler.getObjects().get(i);
            if (tempObj != this) {
                attractors.add(tempObj.getPos().getAttractionFrom(pos));
            }
            attractors.add(tempObj.getCenter().getOppositeFrom(pos).getAttractionFrom(pos));
        }
        
        

        Point target = GeoMath.totalVectorAdd(attractors);
        double distance = Math.hypot(target.getX(), target.getY());
        target.setX(target.getX() * accel / distance);
        target.setY(target.getY() * accel / distance);
        speed.translateX(target.getX());
        speed.translateY(target.getY());
    }

    public void render(Graphics g) {
        super.render(g);
    }
}