import java.awt.*;

public abstract class GameObject {
    protected int xRender, yRender, xSize, ySize;
    protected ID id;
    protected boolean fixed;
    protected double minSpeed, maxSpeed, xSpeed, ySpeed, xPos, yPos;

    protected Handler handler;

    public GameObject(ID id, double xPos, double yPos, int xSize, int ySize, Handler handler) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        xSpeed = 0;
        ySpeed = 0;
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
                double totalSpeed = (double) Math.sqrt((xSpeed * xSpeed) + (ySpeed * ySpeed));
                if (totalSpeed > maxSpeed) {
                    double ratio = maxSpeed / totalSpeed;
                    xSpeed *= ratio;
                    ySpeed *= ratio;
                } else if (totalSpeed < minSpeed) {
                    double ratio = minSpeed / totalSpeed;
                    xSpeed *= ratio;
                    ySpeed *= ratio;
                }
                xPos += xSpeed;
                yPos += ySpeed;
            }
        }
    }

    public void render(Graphics g) {
        xRender = (int)(xPos - (double)xSize / 2);
        yRender = (int)(yPos - (double)ySize / 2);

    }


    public double getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
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

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
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
