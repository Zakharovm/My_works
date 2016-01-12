package existingExceptionClass.file;

import java.io.FileNotFoundException;

public class Directory extends File {


    private File[] filesArray = new File[3];

    public Directory(String name, File[] array) {
        super.name = name;
        this.filesArray = array;
    }

    public File getFile(String filename) throws FileNotFoundException {
        int temp = 0;
        for (int i = 0; i < filesArray.length; i++) {
            if (filename.equals(filesArray[i].getName())) {
                temp = i;
                break;
            } else if (i==filesArray.length - 1) {
                throw new FileNotFoundException(filename);
            }
        }
        return filesArray[temp];
    }
}




