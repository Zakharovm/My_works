package caesarCipher;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ArrayList<File> collectionOfFiles = new ArrayList<>(); //collection of files
        collectionOfFiles.add(new Audio("ghe.mp3", 10));
        collectionOfFiles.add(new Image("picture.jpg", 5));
        collectionOfFiles.add(new Text("hello.txt", 1));
        collectionOfFiles.add(new Image("image.jpg", 4));
        collectionOfFiles.add(new Text("photo.txt", 200));

        Directory directory = new Directory("Files", 220, collectionOfFiles);

        ArrayList<Flower> collectionOfFlowers = new ArrayList<>(); // collection of flowers
        collectionOfFlowers.add(new Rose("rose", 3));
        collectionOfFlowers.add(new Tulip("tulip", 2));
        collectionOfFlowers.add(new Chamomile("chamomile", 1));
        collectionOfFlowers.add(new Aster("aster", 4));

        ArrayList<Instrument> collectionOfInstruments = new ArrayList<>(); //collection of instruments
        collectionOfInstruments.add(new Trumpet("trumpet"));
        collectionOfInstruments.add(new Piano("piano"));
        collectionOfInstruments.add(new Guitar("guitar"));


        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();
        String inputText;
        boolean correct = true;
        int choice;

        while (correct) {
            System.out.println("What are you going to do? Input:\n1 - encrypt message, 2 - decrypt message, 3 - encrypt collection of files, 4 - encrypt collection flowers, 5 - encrypt collection of instruments");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputText = cipher.encryption(input(), 4);
                    System.out.println("Your text was encrypted into: ");
                    output(inputText);
                    correct = false;
                    break;
                case 2:
                    inputText = cipher.decryption(input(), 4);
                    System.out.println("Your text was decrypted into: ");
                    output(inputText);
                    correct = false;
                    break;
                case 3:
                    System.out.println(directory.getFiles().toString());
                    inputText = cipher.convertCollectionToString(directory.getFiles());
                    inputText = cipher.encryption(inputText, 4);
                    output(inputText);
                    correct = false;
                    break;
                case 4:
                    System.out.println(collectionOfFlowers.toString());
                    inputText = cipher.convertCollectionToString(collectionOfFlowers);
                    inputText = cipher.encryption(inputText, 4);
                    output(inputText);
                    correct = false;
                    break;
                case 5:
                    System.out.println(collectionOfInstruments.toString());
                    inputText = cipher.convertCollectionToString(collectionOfInstruments);
                    inputText = cipher.encryption(inputText, 4);
                    output(inputText);
                    correct = false;
                    break;
                default:
                    System.out.println("[Error]: There is no such option. Try again.");
            }
        }
    }

    public static void output(String text) {
        System.out.println(text);
    }

    public static String input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your text: ");
        return scanner.nextLine();
    }
}
