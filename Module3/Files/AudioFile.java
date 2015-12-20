// наследуем класс File аудиофайлом
class AudioFile extends File {
    private String bitrate;

    // создаем и конструктор
    public AudioFile(String n, String s, String p) {
        name = n;
        extension = s;
        bitrate = p;
    }
}