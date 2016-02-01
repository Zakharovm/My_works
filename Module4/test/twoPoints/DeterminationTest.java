package twoPoints;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeterminationTest {
    private Determination determination;

    @BeforeClass
    public void setUpClass() {
        determination = new Determination();

    }

    @Test
    public void testCalculateDistance() {
        final Point point1 = new Point(1,1);
        final Point point2 = new Point(1,5);
        final double result = determination.calculateDistance(point1, point2);

        Assert.assertEquals(4, result, 0.001);
    }
}