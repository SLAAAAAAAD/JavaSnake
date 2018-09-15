public final class FuzzyMath{
    private FuzzyMath() {
    }

    public static double percentCloser(double current, double target, double percent){
        return (target - current) * percent + current;
    }
}
