package maxMinNumber;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxMinTest {
    private static MaxMin maxMin;

    @BeforeClass
    public static void setUpClass() throws Exception {
        maxMin = new MaxMin();
    }

    @Test
    public void testFindMax() {
        final int[] intArray = {5, -10, 15, 3, 2, 0, -2};
        final int result = maxMin.findMax(intArray);

        Assert.assertEquals(15, result);
    }

    @Test
    public void testFindMin() {
        final int[] intArray = {14,-13,214,15,-123,41,-124};
        final int result = maxMin.findMin(intArray);

        Assert.assertEquals(-124, result);

    }
}