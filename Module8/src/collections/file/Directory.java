package collections.file;

import java.util.ArrayList;

public class Directory extends File {

    public ArrayList<File> arrayList = new ArrayList<>();

    public Directory(String name, int size, ArrayList<File> arrayList) {
        super(name, size);
        this.arrayList = arrayList;
    }

    public ArrayList<File> getArrayList() {
        return arrayList;
    }

    public void sortByName(ArrayList<File> arrayList) {
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

    public void sortBySize(ArrayList<File> arrayList) {
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
