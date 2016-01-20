package ExceptionClasses.instrument;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int GUITAR_PRICE = 100; // magic numbers anti-pattern solution
        final int PIANO_PRICE = 200; // magic numbers anti-pattern solution
        final int TRUMPET_PRICE = 150; // magic numbers anti-pattern solution
        final Instrument[] instrumentArray = {new Guitar("Guitar", GUITAR_PRICE), new Piano("Piano", PIANO_PRICE), new Trumpet("Trumpet", TRUMPET_PRICE)};
        final Scanner scanner = new Scanner(System.in);
        final int CASH = 200;
        Shop shop = new Shop(instrumentArray);

        System.out.println("Input the name of the instrument, which you want to buy:");
        String instrumentName = scanner.nextLine();
        System.out.println("We have " + instrumentArray.length + " instruments. Input the quantity of instruments, which you want to buy: ");
        int quantityOfInstruments = scanner.nextInt();


        try {
            shop.sellInstrument(quantityOfInstruments);
            System.out.println("You have bought " + quantityOfInstruments + " instruments for " + shop.countPrice(instrumentName, CASH, quantityOfInstruments) + "$");
        } catch (IndexOutOfBoundsException ex) {
            System.out.print("You wanted to buy " + quantityOfInstruments + ", but there are only " + instrumentArray.length + " instruments in the shop.");
        } catch (NotEnoughMoneyException e) {
            System.out.println("Not enough money for this purchase. You need " + e.getSum() + "$ more");
        }
    }
}

