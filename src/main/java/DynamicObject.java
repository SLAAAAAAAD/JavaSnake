import geometrical_components.GeoMath;
import geometrical_components.Line;
import geometrical_components.Point;

import java.awt.*;
import java.util.ArrayList;

public abstract class DynamicObject extends GameObject {
    protected int xRender, yRender, xSize, ySize;

    protected Point speed, pos;

    protected Handler handler;

    protected boolean dead = false;

    public DynamicObject(Point pos, int xSize, int ySize, Handler handler) {
        super();
        this.pos = pos;
        this.speed = new Point(0, 0);
        this.xSize = xSize;
        this.ySize = ySize;
        this.handler = handler;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        xRender = (int) (pos.getX() - (double) xSize / 2 - handler.getCamera().getPos().getX());
        yRender = (int) (pos.getY() - (double) ySize / 2 - handler.getCamera().getPos().getY());
    }

    public Point checkCollision(Line line) {
        return null;
    }

    public void die(){

    }


    public Point getSpeed() {
        return speed;
    }

    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public int getxRender() {
        return xRender;
    }

    public int getyRender() {
        return yRender;
    }

    public ArrayList<Line> getCollidables() {
        return null;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean isdead) {
        this.dead = dead;
    }

    public Point getCenter(){
        return pos;
    }

    public Point getLead(double frames) {
        Point temp = new Point(speed.getX(), speed.getY());
        temp.translateX(temp.getX() * frames);
        temp.translateY(temp.getY() * frames);
        return GeoMath.addPoints(pos, temp);
    }
}
