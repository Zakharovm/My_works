package sort;

public class SortArray {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temporaryVar = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporaryVar;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currElem = arr[i];
            for (int prevKey = i - 1; prevKey >= 0 && arr[prevKey] > currElem; prevKey--) {
                arr[prevKey + 1] = arr[prevKey];
                arr[prevKey] = currElem;
            }
        }
    }


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

