package ownExceptionClass.file;

import java.util.Arrays;
import java.util.Scanner;
//Задание: Добавление файла с именем, которое не должно быть пустым или null, в папку
public class Runner {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final File[] filesArray = new File[5];
        final FileNameValidator validator = new FileNameValidator();
        Directory directory = new Directory("Файлы", filesArray);

        System.out.println("Input the name of the file, which you want to add: ");
        final String fileName = scanner.nextLine();

        try {
            validator.validate(fileName);
            filesArray[0] = new File(fileName);

            System.out.println("You have added file '" + fileName + "' to the directory");
        } catch (FileNameErrorException e) {
            System.out.println("Exception occurred. Your file name is ' " + e.getFileName() + "'");
        }

    }
}
