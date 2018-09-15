public class Camera {
    private double xPos;
    private double yPos;

    private int width;
    private int height;

    private GameObject target;

    public Camera(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void tick() {
        xPos = target.getxPos() - width / 2;
        yPos = target.getyPos() - height / 2;
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
