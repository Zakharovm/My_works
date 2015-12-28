package maxMinNumber;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int[] intArray = new int[7];
        final Scanner scanner = new Scanner(System.in);
        int maxNumber;
        int minNumber;

        //Input of the array
        System.out.println("Input the numbers of the array: ");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }

        maxNumber = intArray[0];
        minNumber = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] >= maxNumber) {
                maxNumber = intArray[i];
            } else if (intArray[i] < minNumber) {
                minNumber = intArray[i];
            }
        }

        //Output of the array
        for (int element : intArray) {
            System.out.print(element + " | ");
        }
        System.out.println("\n" + "Maximum element is: " + maxNumber);
        System.out.println("Minimum value is: " + minNumber);
    }
}
