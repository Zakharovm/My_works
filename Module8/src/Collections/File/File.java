package Collections.File;

public class File {
    public static final int COLUMN_NAME_WIDTH = 16;
    public static final int COLUMN_SIZE_WIDTH = 6;
    protected String name;
    protected int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String str1 = " " + name;
        String str2 = " " + size;
        int quantityOfSpacesName = COLUMN_NAME_WIDTH - name.length();
        for (int i = 0; i < quantityOfSpacesName; i++) {
            str1 += " ";
        }

        int quantityOfSpacesSize = COLUMN_SIZE_WIDTH - str2.length();
        for (int i = 0; i < quantityOfSpacesSize; i++) {
            str2 += " ";
        }

        return "|" + str1 + "|" + str2 + "|";
    }
}
