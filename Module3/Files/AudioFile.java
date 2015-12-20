// наследуем класс File аудиофайлом
public class AudioFile extends File {
    private int bitrate;

    AudioFile(int kbs) {
        bitrate = kbs;
    }
}