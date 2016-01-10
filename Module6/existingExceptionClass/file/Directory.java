package existingExceptionClass.file;

import java.io.FileNotFoundException;

public class Directory {

    private static File[] filesArray = new File[3];


    public Directory(File[] array) {
        for (int i = 0; i < filesArray.length; i++) {
            this.filesArray[i] = array[i];
        }
    }

    public static File[] getFilesArray(String fileName) throws FileNotFoundException {
        return filesArray;
    }
}

