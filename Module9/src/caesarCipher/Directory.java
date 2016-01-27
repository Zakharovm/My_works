package caesarCipher;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File {
    public List<File> files = new ArrayList<>();

    public Directory(String name, int size, List<File> files) {
        super(name, size);
        this.files = files;
    }

    public List<File> getFiles() {
        return files;
    }

}
