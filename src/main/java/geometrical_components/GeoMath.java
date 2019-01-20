package geometrical_components;

public class GeoMath {
    private GeoMath() {
    }

    public static boolean rangeIntersect(double a, double b, double c, double d) {
        return (Math.min(a,b) <= Math.max(c,d) && Math.min(c,d) <= Math.max(a,b));

//        return (a <= d && c <= b);
    }

    public static Point addPoints(Point p1, Point p2) {
        return new Point(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }

    public static Point subtractPoints(Point p1, Point p2) {
        return new Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    public static Point multiplyPoints(Point p1, Point p2) {
        return new Point((p1.getX() * p2.getX()) - (p1.getY() * p2.getY()), (p1.getX() * p2.getY()) + (p1.getY() * p2.getX()));
    }

    public static Point lineIntersect(Line L1, Line L2) {
        Point A = L1.getP1();
        Point B = L1.getP2();
        Point C = L2.getP1();
        Point D = L2.getP2();

        if (!rangeIntersect(A.getX(), B.getX(), C.getX(), D.getX())) {
            return null;
        }
        if (!rangeIntersect(A.getY(), B.getY(), C.getY(), D.getY())) {
            return null;
        }

        double m1 = L1.getSlope();
        double b1 = L1.getYIntercept();
        double m2 = L2.getSlope();
        double b2 = L2.getYIntercept();

        double x = 0 - ((b1 - b2) / (m1 - m2));

//        if (!rangeIntersect(A.getX(), B.getX(), x, x) || !rangeIntersect(C.getX(), D.getX(), x, x)) {
//            return null;
//        }

        double y = (m1 * x) + b1;

        return new Point(x, y);
    }
}
