package geometrical_components;

import static java.lang.Double.NaN;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Point p) {
        x += p.getX();
        y += p.getY();
    }

    public void subtract(Point p) {
        x -= p.getX();
        y -= p.getY();
    }

    public void translateX(double x) {
        this.x += x;
    }

    public void translateY(double y) {
        this.y += y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return Math.sqrt(x * x + y * y);
    }

    public double getT() {
        return Math.atan2(y, x);
    }

    // UCP stands for Unit Circle Point
    // the point on the unit circle that shares the same theta as the given point.
    public Point getUCP() {
        return new Point(x / getR(), y / getR());
    }

    public double getRfrom(Point p) {
        Point temp = GeoMath.subtractPoints(this, p);
        return temp.getR();
    }

    public double getTfrom(Point p) {
        Point temp = GeoMath.subtractPoints(this, p);
        return temp.getT();
    }

    public Point getUCPfrom(Point p) {
        Point temp = GeoMath.subtractPoints(this, p);
        return temp.getUCP();
    }

    public Point getAttraction() {
        if(getT() == 0){
            return null;
        }
        double ratio = Math.pow(1 / getT(), 2);
        return new Point(x * ratio, y * ratio);
    }

    public Point getAttractionFrom(Point p) {
        Point temp = GeoMath.subtractPoints(this, p);
        return temp.getAttraction();
    }

    public Point getOpposite() {
        return new Point(0 - x, 0 - y);
    }

    public Point getOppositeFrom(Point p){
        Point temp = GeoMath.subtractPoints(this, p);
        return temp.getOpposite();
    }
}
