package maxMinNumber;

public class MaxMin {
    public static int findMax(int[] array) {
        int maxNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= maxNumber) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

    public static int findMin(int[] array) {
        int minNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= minNumber) {
                minNumber = array[i];
            }
        }
        return minNumber;
    }

}


