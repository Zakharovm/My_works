package sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortArrayTest {
    private static SortArray sortArray;

    @BeforeClass
    public static void setUpClass() {
         sortArray = new SortArray();
    }

    @Test
    public void testBubbleSort() {
        final int[] intArray = {5, 4, 10, -3, 123, 0};
        sortArray.bubbleSort(intArray);
        final int[] expectedArray = {-3, 0, 4, 5, 10, 123};
        Assert.assertArrayEquals(expectedArray ,intArray);
    }

    @Test
    public void testInsertionSort() {
        final int[] intArray = {10, 4, 10, -3, 13, 0};
        sortArray.insertionSort(intArray);
        final int[] expectedArray = {-3, 0, 4, 10, 10, 13};
        Assert.assertArrayEquals(expectedArray ,intArray);
    }

    @Test
    public void testSelectionSort() {
        final int[] intArray = {5, 4, 10, -3, 123, 1000};
        sortArray.selectionSort(intArray);
        final int[] expectedArray = {-3, 4, 5, 10, 123, 1000};
        Assert.assertArrayEquals(expectedArray ,intArray);
    }
}