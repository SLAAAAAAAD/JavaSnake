package geometrical_components;

public class Line {
    private Vector p1;
    private Vector p2;

    public Line(Vector p1, Vector p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void setPoints(Vector p1, Vector p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector getMidpoint(){
        return new Vector((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    public double getlength(){
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    public double getSlope(){
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());

    }

    public Vector getP1() {
        return p1;
    }

    public void setP1(Vector p1) {
        this.p1 = p1;
    }

    public Vector getP2() {
        return p2;
    }

    public void setP2(Vector p2) {
        this.p2 = p2;
    }
}
