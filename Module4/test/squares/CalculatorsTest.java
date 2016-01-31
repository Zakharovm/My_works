package squares;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorsTest {
    private static Calculators calculators;



    @BeforeClass
    public static void setUpClass () {
        calculators = new Calculators();
    }

    @Test
    public void testFindTriangleSquare() {
        final double side1 = 2;
        final double side2 = 2;
        final double side3 = 2;
        final Triangle triangle = new Triangle(side1, side2, side3);
        final double result = calculators.findTriangleSquare(triangle);

        Assert.assertEquals(Math.sqrt(3) ,result, 0.0001);
    }

    @Test
    public void testFindRectangleSquare() {
        final double side1 = 2;
        final double side2 = 4;
        final Rectangle rectangle = new Rectangle(side1, side2);
        final double result = calculators.findRectangleSquare(rectangle);

        Assert.assertEquals(side1*side2, result, 0.0001);
    }

    @Test
    public void testFindCircleSquare() {
        final double radius = 10;
        final Circle circle = new Circle(radius);
        final double result = calculators.findCircleSquare(circle);

        Assert.assertEquals(Math.PI*radius*radius, result, 0.0001);
    }
}