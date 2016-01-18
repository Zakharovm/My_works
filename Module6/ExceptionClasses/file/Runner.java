package ExceptionClasses.file;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final File[] filesArray = {new AudioFile("123.mp3"), new TextFile("data.txt"), new ImageFile("image.jpg")};

        System.out.println("Input the name of the file, which you want to find: ");
        String fileName = scanner.nextLine();
        try {
            if (fileName == null || fileName.equals("")) {
                throw new WrongFileNameException(fileName);
            } else {
                System.out.println("Your file is " + new Directory("Файлы", filesArray).getFile(fileName).getName());
            }

        } catch (WrongFileNameException e) {
            System.out.println("[Error!]: Your file name is ' " + e.getFileName() + "' , but it should consist of at least one letter or number");
        } catch (FileNotFoundException e) {
            System.out.print("файл " + fileName + " не найден");
        }

    }
}
