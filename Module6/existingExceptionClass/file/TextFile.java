package existingExceptionClass.file;

// наследуем класс File текстовым файлом
public class TextFile extends File {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

}