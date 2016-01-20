package ExceptionClasses.flower;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Flower[] flowersArray = {new Aster(), new Rose(), new Tulip(), new Camomile()};

        Bouquet bouquet = new Bouquet(flowersArray);
        System.out.println("Input the quantity of flowers for you bouquet: ");
        int quantityOfFlowers = scanner.nextInt();
        try {
            if (quantityOfFlowers == 0) {
                throw new WrongNumberOfFlowers(quantityOfFlowers);
            }
            bouquet.create(quantityOfFlowers);
            System.out.println("Your bouquet of " + quantityOfFlowers + " flowers is ready!");
        } catch (WrongNumberOfFlowers ex) {
            System.out.println("[Error]: The empty number of flowers. The bouquet should consist of at least 1 flower");
        } catch (NegativeArraySizeException e) {
            System.out.println("[Error]: You input the negative number");

        }
    }
}
