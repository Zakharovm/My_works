package ExceptionClasses.file;


public class WrongFileNameException extends Exception {
    private String fileName;

    public WrongFileNameException(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
