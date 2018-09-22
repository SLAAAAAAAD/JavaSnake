import geometrical_components.Vector;

import java.awt.*;

public abstract class DynamicObject extends GameObject {
    protected int xRender, yRender, xSize, ySize;
    protected boolean fixed;
    protected double minSpeed, maxSpeed;
    protected Vector speed, pos;

    protected Handler handler;

    public DynamicObject(ID id, Vector pos, int xSize, int ySize, Handler handler) {
        super(id);
        this.pos = pos;
        this.speed = new Vector(0, 0);
        this.xSize = xSize;
        this.ySize = ySize;
        minSpeed = 1.5;
        maxSpeed = 6;
        this.handler = handler;
        if (id == ID.TERRAIN) {
            fixed = true;
        }
    }

    public void tick() {
        if (!fixed) {
            if (id == ID.PLAYER || id == ID.ENEMY) {
                double totalSpeed = Math.hypot(speed.getX(), speed.getY());
                if (totalSpeed > maxSpeed) {
                    double ratio = maxSpeed / totalSpeed;
                    speed.setX(speed.getX() * ratio);
                    speed.setY(speed.getY() * ratio);
                } else if (totalSpeed < minSpeed) {
                    double ratio = minSpeed / totalSpeed;
                    speed.setX(speed.getX() * ratio);
                    speed.setY(speed.getY() * ratio);
                }
                pos.vectorAdd(speed);
            }
        }
    }

    public void render(Graphics g) {
        xRender = (int) (pos.getX() - (double) xSize / 2 - handler.getCamera().getPos().getX());
        yRender = (int) (pos.getY() - (double) ySize / 2 - handler.getCamera().getPos().getY());
    }


    public Vector getSpeed() {
        return speed;
    }

    public void setSpeed(Vector speed) {
        this.speed = speed;
    }

    public Vector getPos() {
        return pos;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
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

    public void setxRender(int xRender) {
        this.xRender = xRender;
    }

    public int getyRender() {
        return yRender;
    }

    public void setyRender(int yRender) {
        this.yRender = yRender;
    }

}
