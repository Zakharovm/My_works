package existingExceptionClass.file;

import java.io.FileNotFoundException;

public class Directory extends File {
    boolean check = false;
    int temp = 0;

    private File[] filesArray = new File[3];

    public Directory(String name, File[] array) {
        super.name = name;
        this.filesArray = array;
    }

    public File getFilesArray(String filename) throws FileNotFoundException {
        for (int i = 0; i < filesArray.length; i++) {
            if (filename.equals(filesArray[i].getName())) {
                check = true;
                temp = i;
            }

        }
        if (check == true) {
            return filesArray[temp];
        } else {
            throw new FileNotFoundException(filename);
        }
    }
}

