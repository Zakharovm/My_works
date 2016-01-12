package existingExceptionClass.file;

// наследуем класс File аудиофайлом
public class AudioFile extends File {
    private static String name;

    public AudioFile(String name) {
        super.name = name;
    }

}