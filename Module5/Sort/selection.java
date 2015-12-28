package Sort;

public class selection {
    public static void selectionSort(int[] array) {
        int temp;

        for (int sortedPartIndex = 0; sortedPartIndex < array.length - 1; sortedPartIndex++) {
            int min = sortedPartIndex;
            for (int unsortedPartIndex = sortedPartIndex + 1; unsortedPartIndex < array.length; unsortedPartIndex++)
                if (array[unsortedPartIndex] < array[min]) {
                    min = unsortedPartIndex;
                }
            // Swap the values if we have an element that is less than the current position element
            if (sortedPartIndex != min) {
                temp = array[min];
                array[min] = array[sortedPartIndex];
                array[sortedPartIndex] = temp;
            }
        }
    }
}
