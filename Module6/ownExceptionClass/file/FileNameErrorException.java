package ownExceptionClass.file;

public class FileNameErrorException extends Exception {
    private String fileName;

    public FileNameErrorException(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
