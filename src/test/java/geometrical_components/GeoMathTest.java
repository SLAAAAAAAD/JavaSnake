package geometrical_components;

import org.junit.Assert;
import org.junit.Test;

public class GeoMathTest {

    @Test
    public void testCollision() {
        Point A = new Point(3,4);
        Point B = new Point(6,9);
        Point C = new Point(18,2);

        Line AB = new Line(A,B);
        Line BC = new Line(B,C);

        Assert.assertTrue(GeoMath.lineIntersect(AB, BC) != null);
    }


}
