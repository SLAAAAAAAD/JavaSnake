import geometrical_components.Line;
import geometrical_components.Point;

public class FuzzyMath {
    private FuzzyMath() {
    }

    public static double percentCloser(double current, double target, double percent) {
        return (target - current) * percent + current;
    }

    public static boolean rangeIntersect(double a, double b, double c, double d) {
        return (a <= d && c <= b);
    }

    public static Point lineIntersect(Line L1, Line L2) {
        Point A = L1.getP1();
        Point B = L1.getP2();
        Point C = L2.getP1();
        Point D = L2.getP2();

        double Ax = A.getX();
        double Ay = A.getY();
        double Bx = B.getX();
        double By = B.getY();
        double Cx = C.getX();
        double Cy = C.getY();
        double Dx = D.getX();
        double Dy = D.getY();

        if (!rangeIntersect(Ax, Bx, Cx, Dx) && !rangeIntersect(Ay, By, Cy, Dy)) {
            return null;
        }

//        double R = Math.sqrt((Bx - Ax) * (Bx - Ax) + (By - Ay) * (By - Ay));
//
//        double newCy = (((Cx - Ax) * (By - Ay) + (Cy - Ay) * (Bx - Ax)) * R) / ((Bx - Ax) * (Bx - Ax) + (By - Ay) * (By - Ay));
//        double newDy = (((Dx - Ax) * (By - Ay) + (Dy - Ay) * (Bx - Ax)) * R) / ((Bx - Ax) * (Bx - Ax) + (By - Ay) * (By - Ay));

        double R = L1.getlength();

        double newCy = ((Cx - Ax) * (By - Ay) + (Cy - Ay) * (Bx - Ax)) / R;
        double newDy = ((Dx - Ax) * (By - Ay) + (Dy - Ay) * (Bx - Ax)) / R;

        if (newCy * newDy > 0) {
            return null;
        }

//        double newCx = (((Cx - Ax) * (Bx - Ax) - (Cy - Ay) * (By - Ay)) * R) / ((Bx - Ax) * (Bx - Ax) + (By - Ay) * (By - Ay));
//        double newDx = (((Dx - Ax) * (Bx - Ax) - (Dy - Ay) * (By - Ay)) * R) / ((Bx - Ax) * (Bx - Ax) + (By - Ay) * (By - Ay));

        double newCx = ((Cx - Ax) * (Bx - Ax) + (Cy - Ay) * (By - Ay)) / R;
        double newDx = ((Dx - Ax) * (Bx - Ax) + (Dy - Ay) * (By - Ay)) / R;

        Line newLine = new Line(new Point(newCx, newCy), new Point(newDx, newDy));

        double P = newLine.getXIntercept();
        if (P < 0 || P > L1.getlength()) {
            return null;
        }

        double X = P / R * (Bx - Ax) + Ax;
        double Y = P / R * (By - Ay) + Ay;

        return new Point(X, Y);
    }
}