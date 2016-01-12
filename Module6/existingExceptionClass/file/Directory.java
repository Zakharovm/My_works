package existingExceptionClass.file;

import java.io.FileNotFoundException;

public class Directory extends File {
    static boolean check = false;
    static int temp = 0;

    private static File[] filesArray = new File[3];

    public Directory(String name) {
        super.name = name;
    }

    public Directory(File[] array) {
        this.filesArray = array;
    }

    public static File getFilesArray(String filename) throws FileNotFoundException {
        for (int i = 0; i < filesArray.length; i++) {
            if (filename == filesArray[i].getName()) {
                check = true;
                temp = i;
            }

        }
        if (check == true) {
            return filesArray[temp];
        }
        else {
            throw new FileNotFoundException(filename);
        }
    }
}

