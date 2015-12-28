package Sort;

public class insertion {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currElem = arr[i];
            for (int prevKey = i - 1; prevKey >= 0 && arr[prevKey] > currElem; prevKey--) {
                arr[prevKey + 1] = arr[prevKey];
                arr[prevKey] = currElem;
            }
        }
    }
}
