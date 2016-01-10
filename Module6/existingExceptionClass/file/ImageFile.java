package existingExceptionClass.file;

// наследуем класс File графическим файлом
public class ImageFile extends File {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }
}