package geometrical_components;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void setPoints(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getMidpoint() {
        return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    public double getlength() {
        return p2.getRfrom(p1);
    }

    public double getSlope() {
        Point temp = p2.getUCPfrom(p1);
        return temp.getY() / temp.getX();
    }

    public double getAngle() {
        return p2.getTfrom(p1);
    }

    public double getYIntercept() {
        return p1.getY() - getSlope() * p1.getX();
    }

    public double getXIntercept() {
        return p1.getX() - p1.getY() / getSlope();
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
}
