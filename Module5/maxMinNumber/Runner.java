package maxMinNumber;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int[] intArray = new int[7];
        final Scanner scanner = new Scanner(System.in);

        //Input of the array
        System.out.println("Input the numbers of the array: ");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }

        //Output of the array
        for (int element : intArray) {
            System.out.print(element + " | ");
        }
        System.out.println("\n" + "Maximum element is: " + MaxMin.findMax(intArray));
        System.out.println("Minimum value is: " + MaxMin.findMin(intArray));
    }
}
