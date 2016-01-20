package ExceptionClasses.file;

public class File {
    protected String name;

    public File(String fileName) {
        if (fileName == null || fileName.equals("")) {
            try {
                throw new WrongFileNameException(fileName);
            } catch (WrongFileNameException e) {
                System.out.println("[Error]: Wrong file name. It should consists of at least one number or letter");
            }
        } else {
            this.name = fileName;
        }
    }
    public String getName() {
        return name;
    }
}
