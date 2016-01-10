package existingExceptionClass.file;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        String filename =" ";
        final Scanner scanner = new Scanner(System.in);
        File[] filesArray = new File[3];



        try {

            new Directory(filesArray).getFilesArray(filename);//обработка IOException не предусмотрена
            System.out.println("Your file is " + filename);
        } catch (FileNotFoundException e) {

            System.out.print("файл " + filename + " не найден");

        }

    }
}
