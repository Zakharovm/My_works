import org.junit.Assert;
import org.junit.Test;

public class SquareSumImpTest {
    SquareSumImp squareSumImp;

    @Test(timeout = 3000)
    public void getSquareSum() throws Exception {
        squareSumImp = new SquareSumImp();
        int[] array = {1, 2, 1, 3, 1, 4, 1, 5};
        int numberOfThreads = 3;
        long result = squareSumImp.getSquareSum(array, numberOfThreads);

        Assert.assertEquals(result, 58, 0.0001);
        System.out.println("Test is done");

    }

}