import geometrical_components.GeoMath;
import geometrical_components.Line;
import geometrical_components.Point;

import java.awt.*;
import java.util.ArrayList;

public class AISnake extends Snake {

    private double aiTargetLead = 50
            , aiTargetWeight = 1
            , aiAvoidDistance = 50
            , aiAvoidWeight = 100
            , aiSelfAvoidDistance = 50
            , aiSelfAvoidWeight = 100;

    public AISnake(Point pos, Handler handler) {
        super(pos, handler);
        color = Color.red;
//        accel = 10;
//        setMinSpeed(0);
//        setMaxSpeed(10);
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
                Point temp = tempObj.getLead(aiTargetLead);
//                temp.setX(FuzzyMath.percentCloser(temp.getX(), pos.getX(), 0.5));
//                temp.setY(FuzzyMath.percentCloser(temp.getY(), pos.getY(), 0.5));
                attractors.add(temp.getAttractionFrom(aiTargetWeight, pos));

                ArrayList<Line> tempAL = tempObj.getCollidables();
                for (int j = 0; j < tempAL.size(); j++) {
                    Point temp2 = tempAL.get(j).getMidpoint();
                    if (temp2.getRfrom(pos) < aiAvoidDistance) {
                        attractors.add(temp2.getOppositeFrom(pos).getAttractionFrom(aiAvoidWeight, pos));
                    }
                }
            } else {
                ArrayList<Line> tempAL = tempObj.getCollidables();
                for (int j = 0; j < tempAL.size() -50; j++) {
                    Point temp2 = tempAL.get(j).getMidpoint();
                    if (temp2.getRfrom(getLead(0)) < aiSelfAvoidDistance) {
                        attractors.add(temp2.getOppositeFrom(pos).getAttractionFrom(aiSelfAvoidWeight, pos));
                    }
                }
            }
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