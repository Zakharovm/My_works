package fileUploading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Runner {

    public static final int SHIFT_NUMBER = 4;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = null;
        BufferedWriter buffer = null;
        Cipher cipher = new Cipher();
        boolean correct = true;
        String message = "";

        while (correct) {
            System.out.println("What do you want to do? [E]ncrypt or [D]ecrypt?");
            String choice = scanner.nextLine();
            switch (choice) {
                case "E":
                    message = cipher.encryption(input(), SHIFT_NUMBER);
                    correct = false;
                    break;
                case "D":
                    message = cipher.decryption(input(), SHIFT_NUMBER);
                    correct = false;
                    break;
                default:
                    System.out.println("There is no such variant. Try again.");
            }
        }

        try {
            writer = new FileWriter("receivedMessage.txt");

            writer.write(message);

        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static String input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your string: ");
        return scanner.nextLine();
    }


}


