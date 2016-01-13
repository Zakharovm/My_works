package existingExceptionClass.instrument;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final Instrument[] instrumentArray = new Instrument[5];
        final Scanner scanner = new Scanner(System.in);

        System.out.println("We have "+ instrumentArray.length + " instruments. Input the quantity of instruments, which you want to buy: ");
        int quantityOfInstruments = scanner.nextInt();

        try {
            new Shop(instrumentArray).sellInstrument(quantityOfInstruments);
            System.out.println("You have bought " + quantityOfInstruments + " instruments.");

        } catch (IndexOutOfBoundsException e) {

            System.out.print("You wanted to buy " + quantityOfInstruments + ", but there are only " + instrumentArray.length + " instruments in the shop.");
        }
    }
}

