import geometrical_components.Line;
import geometrical_components.Point;

public class FuzzyMath {
    private FuzzyMath() {
    }

    public static double percentCloser(double current, double target, double percent) {
        return (target - current) * percent + current;
    }
}
