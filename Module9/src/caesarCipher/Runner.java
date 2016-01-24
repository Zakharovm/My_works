package caesarCipher;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();
        String inputText;

        System.out.println("Input your text: ");
        inputText = scanner.nextLine();

        System.out.println("What are you going to do? Input:\n1 - encrypt, 2 - decrypt");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                inputText = cipher.encryption(inputText, 4);
                System.out.println("Your text was encrypted into: ");
                output(inputText);
                break;
            case 2:
                inputText = cipher.decryption(inputText, 4);
                System.out.println("Your text was decrypted into: ");
                output(inputText);
                break;
            default:
                System.out.println("[Error]: There is no such option");
        }

    }

    public static void output(String text) {
        System.out.println(text);
    }
}
