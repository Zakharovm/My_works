package existingExceptionClass.file;

// наследуем класс File аудиофайлом
public class AudioFile extends File {
    private String name;

    public AudioFile(String name) {
        this.name = name;
    }
}