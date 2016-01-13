package ownExceptionClass.file;

public class FileNameValidator {
    public void validate(String fileName) throws FileNameErrorException {
        if (fileName == null || fileName.equals("")) {
            throw new FileNameErrorException(fileName);
        }
    }
}
