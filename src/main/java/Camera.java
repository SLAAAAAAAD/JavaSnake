import geometrical_components.Vector;

public class Camera {
    private Vector pos;

    private int width;
    private int height;

    private double snap;
    private double lead;

    private DynamicObject target;

    public Camera(int width, int height, double snap, double lead) {
        this.width = width;
        this.height = height;
        this.snap = snap;
        this.lead = lead;
        pos = new Vector(0,0);
    }

    public void tick() {

        double x = target.getPos().getX() - target.getxSize() / 2 - width / 2 + target.getSpeed().getX() * lead;
        double y = target.getPos().getY() - target.getySize() / 2 - width / 2 + target.getSpeed().getY() * lead;
        pos.setX(FuzzyMath.percentCloser(pos.getX(), x, snap));
        pos.setY(FuzzyMath.percentCloser(pos.getY(), y, snap));
    }

    public Vector getPos() {
        return pos;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public DynamicObject getTarget() {
        return target;
    }

    public void setTarget(DynamicObject target) {
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
