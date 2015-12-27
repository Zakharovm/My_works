package maxMinNumber;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double[] doubleArray = new double[7];
        final Scanner scanner = new Scanner(System.in);
        double maxNumber;
        double minNumber;

        //Input of the array
        System.out.println("Input the numbers of the array: ");
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = scanner.nextDouble();
        }

        maxNumber = doubleArray[0];
        minNumber = doubleArray[0];
        for (int i = 0; i < doubleArray.length; i++) {
            if (doubleArray[i] >= maxNumber) {
                maxNumber = doubleArray[i];
            } else if (doubleArray[i] < minNumber) {
                minNumber = doubleArray[i];
            }

        }

        //Output of the array
        for (double element : doubleArray) {
            System.out.print(element + " | ");
        }
        System.out.println("\n" + "Maximum element is: " + maxNumber);
        System.out.println("Minimum value is: " + minNumber);
    }
}
