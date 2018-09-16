public class FuzzyMath{
    private FuzzyMath() {
    }

    public static double percentCloser(double current, double target, double percent){
        return (target - current) * percent + current;
    }

    // does range a - b intersect range c - d?
    public static boolean rangeIntersect(double a, double b, double c, double d){
        return (a <= d && c <= b);
    }

    // does line x11, y11 - x12, y12 intersect line x21, y21 - x22, y22?
    public static boolean lineIntersect(double x11, double y11, double x12, double y12, double x21, double y21, double x22, double y22){
        return (rangeIntersect(x11,x12,x21,x22) && rangeIntersect(y11,y12,y21,y22));
    }
}
