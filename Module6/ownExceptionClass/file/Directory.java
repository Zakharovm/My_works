package ownExceptionClass.file;

public class Directory extends File {


    private File[] filesArray = new File[5];

    public Directory(String name, File[] array) {
        super(name);
        this.filesArray = array;
    }

    public File[] getFilesArray() {
        return filesArray;
    }
}




