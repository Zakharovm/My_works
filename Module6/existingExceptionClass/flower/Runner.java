package existingExceptionClass.flower;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Flower[] flowersArray = {new Aster(),new Rose(),new Tulip(),new Camomile()};

        Bouquet bouquet = new Bouquet(flowersArray);
        System.out.println("Input the quantity of flowers for you bouquet: ");
        int quantityOfFlowers = scanner.nextInt();
        try {
            bouquet.create(quantityOfFlowers);
            System.out.println("Your bouquet of "+ quantityOfFlowers + " flowers is ready!");
        } catch (NegativeArraySizeException e){
            System.out.println("Error: You input the negative number");

        }
    }
}
