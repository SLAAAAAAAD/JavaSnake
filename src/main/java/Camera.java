public class Camera {
    private double xPos;
    private double yPos;

    private GameObject target;

    public Camera(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void tick() {
        xPos = target.getxPos();
        yPos = target.getyPos();
    }


    public double getX() {
        return xPos;
    }

    public void setX(double xPos) {
        this.xPos = xPos;
    }

    public double getY() {
        return yPos;
    }

    public void setY(double yPos) {
        this.yPos = yPos;
    }

    public GameObject getTarget() {
        return target;
    }

    public void setTarget(GameObject target) {
        this.target = target;
    }
}
