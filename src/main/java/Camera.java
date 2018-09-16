public class Camera {
    private double xPos;
    private double yPos;

    private int width;
    private int height;

    private double snap;
    private double lead;

    private GameObject target;

    public Camera(int width, int height, double snap, double lead) {
        this.width = width;
        this.height = height;
        this.snap = snap;
        this.lead = lead;
    }

    public void tick() {
        double x = target.getxPos() - width / 2 + target.getxSpeed() * lead;
        double y = target.getyPos() - height / 2 + target.getySpeed() * lead;
        xPos = FuzzyMath.percentCloser(xPos, x, snap);
        yPos = FuzzyMath.percentCloser(yPos, y, snap);
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

    public double getsnap() {
        return snap;
    }

    public void setsnap(double snap) {
        this.snap = snap;
    }

    public double getLead() {
        return lead;
    }

    public void setLead(double lead) {
        this.lead = lead;
    }
}
