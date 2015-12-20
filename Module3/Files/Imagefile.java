// наследуем класс File графическим файлом
class ImageFile extends File {
    private String resolution;

    // создаем и конструктор
    public ImageFile(String n, String s, String p) {
        name = n;
        extension = s;
        resolution = p;
    }
}