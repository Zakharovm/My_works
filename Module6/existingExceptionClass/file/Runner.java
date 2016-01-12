package existingExceptionClass.file;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        String filename = " ";
        final Scanner scanner = new Scanner(System.in);
        File[] filesArray = {new AudioFile("123.mp3"), new TextFile("data.txt"), new ImageFile("image.jpg")};

        try {
            System.out.println("Input the name of the file: ");
            filename = scanner.nextLine();
            new Directory("Файлы", filesArray).getFilesArray(filename);
            System.out.println("Your file is " + filename);
        } catch (FileNotFoundException e) {

            System.out.print("файл " + filename + " не найден");

        }

    }
}
