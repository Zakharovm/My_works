package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int choice = 0;
        String method = " ";
        int[] intArray = new int[7];
        final Scanner scanner = new Scanner(System.in);

        //Input of the array
        System.out.println("Input the numbers of the array: ");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }

        System.out.println("Choose the method of sorting:" + "\n" + "1 - bubble, 2 - insertion, 3 - selection, or another number - by method Sort in Arrays class");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                method = "bubble";
                bubble.bubbleSort(intArray);
                break; // вызов метода сортировки пузырьком (выполняется примерно одинаково с Arrays.sort)
            case 2:
                method = "insertion";
                insertion.insertionSort(intArray);
                break; // вызов метода сортировки вставками
            case 3:
                method = "selection";
                selection.selectionSort(intArray);
                break; // вызов метода сортировки выбором
            default:
                method = "Arrays.sort()";
                Arrays.sort(intArray);
                break; // вызов встроенного метода сортировки
        }

        //Output of the array
        for (int element : intArray) {
            System.out.print(element + " | ");
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("program was performed in " + timeSpent + " milliseconds by method " + method);
    }
}
