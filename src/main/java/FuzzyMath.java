import geometrical_components.Line;

public class FuzzyMath {
    private FuzzyMath() {
    }

    public static double percentCloser(double current, double target, double percent) {
        return (target - current) * percent + current;
    }

    // does range a - b intersect range c - d?
    public static boolean rangeIntersect(double a, double b, double c, double d) {
        return (a <= d && c <= b);
    }

    public static boolean lineIntersect(Line a, Line b) {
        return false;
    }
}