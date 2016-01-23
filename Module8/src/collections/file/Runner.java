package collections.file;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Directory directory = new Directory("Files", 220, new ArrayList<>(Arrays.asList(new Audio("a.mp3", 10), new Image("picture.jpg", 5), new Text("hello.txt", 1), new Image("image.jpg", 4), new Text("photo.txt", 200))));
        FileUtils fileUtils = new FileUtils();

        System.out.println("Basic list: ");
        fileUtils.print(directory.getFiles());
        directory.sortByName(directory.getFiles());
        System.out.println("\nThe list, sorted by name: ");
        fileUtils.print(directory.getFiles());
        directory.sortBySize(directory.getFiles());
        System.out.println("\nThe list, sorted by size: ");
        fileUtils.print(directory.getFiles());

    }
}
