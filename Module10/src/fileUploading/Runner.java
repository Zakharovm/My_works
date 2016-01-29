package fileUploading;

import java.io.*;
import java.util.Scanner;

public class Runner {

    public static final int SHIFT_NUMBER = 4;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = null;
        BufferedReader reader = null;
        Cipher cipher = new Cipher();
        boolean correct = true;

        while (correct) {
            System.out.println("What do you want to do? [E]ncrypt or [D]ecrypt?");
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "encryption":
                case "e":
                    String message = cipher.encryption(input("Input the text for encryption: "), SHIFT_NUMBER);
                    String fileName = input("Input the name of file for the text: ");
                    correct = false;
                    try {
                        writer = new FileWriter(fileName);
                        writer.write(message);
                    } finally {
                        if (writer != null) {
                            writer.close();
                        }
                    }
                    break;
                case "decryption":
                case "d":
                    fileName = input("Input the name of file, text you want to decrypt which: ");
                    try {
                        while (!new File(fileName).isFile()) {
                            output("There is no such file. Try again.");
                            fileName = input("Input the name of file, text you want to decrypt which: ");
                        }
                        reader = new BufferedReader(new FileReader(fileName));
                        message = reader.readLine();
                        message = cipher.decryption(message, SHIFT_NUMBER);
                        StringBuilder builder = new StringBuilder("Decrypted text is: \n");
                        message = builder.append(message).toString();
                        output(message);

                    } finally {
                        if (reader != null) {
                            reader.close();
                        }
                    }
                    correct = false;
                    break;
                default:
                    System.out.println("There is no such variant. Try again.");
            }
        }

    }

    public static String input(String text) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(text);
        return scanner.nextLine();
    }

    public static void output(String text) {
        System.out.println(text);
    }


}


