package collections.file;

import java.util.ArrayList;
import java.util.Arrays;

public class Directory extends File {

    public static ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(new Audio("a.mp3", 10), new Image("picture.jpg", 5), new Text("hello.txt", 1), new Image("image.jpg", 4), new Text("photo.txt", 200)));
    public static FileUtils fileUtils = new FileUtils();

    public Directory(String name, int size, ArrayList<File> arrayList) {
        super(name, size);
        this.arrayList = arrayList;
    }

    public static void main(String[] args) {

        System.out.println("Basic list: ");
        fileUtils.print(arrayList);
        sortByName(arrayList);
        System.out.println("\nThe list, sorted by name: ");
        fileUtils.print(arrayList);
        sortBySize(arrayList);
        System.out.println("\nThe list, sorted by size: ");
        fileUtils.print(arrayList);
    }


    public static void sortByName(ArrayList<File> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = 0; j < arrayList.size() - i - 1; j++) {
                String str1 = arrayList.get(j).getName();
                String str2 = arrayList.get(j + 1).getName();
                if (str1.compareTo(str2) > 0) {
                    arrayList.add(j + 1, arrayList.remove(j));
                }
            }
        }
    }

    public static void sortBySize(ArrayList<File> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = 0; j < arrayList.size() - i - 1; j++) {
                int size1 = arrayList.get(j).getSize();
                int size2 = arrayList.get(j + 1).getSize();
                if (size1 > size2) {
                    arrayList.add(j + 1, arrayList.remove(j));
                }
            }
        }
    }

}