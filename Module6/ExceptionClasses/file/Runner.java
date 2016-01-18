package ExceptionClasses.file;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final File[] filesArray = {new AudioFile(""), new TextFile("data.txt"), new ImageFile("image.jpg")};
        Directory directory = new Directory("Файлы", filesArray);

        System.out.println("Input the name of the file, which you want to find: ");
        String fileName = scanner.nextLine();
        try {
            System.out.println("Your file is " + directory.getFile(fileName).getName());
        } catch (FileNotFoundException e) {
            System.out.print("файл " + fileName + " не найден");
        }

    }
}
