package ownExceptionClass.file;

public class Directory extends File {


    private static File[] filesArray = new File[5];

    public Directory(String name, File[] array) {
        super(name);
        this.filesArray = array;
    }

    public static File[] getFilesArray() {
        return filesArray;
    }
}




