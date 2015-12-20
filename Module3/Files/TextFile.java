// наследуем класс File текстовым файлом
class TextFile extends File {
    private String size;

    // создаем и конструктор
    public TextFile(String n, String s, String p) {
        name = n;
        extension = s;
        size = p;
    }

}