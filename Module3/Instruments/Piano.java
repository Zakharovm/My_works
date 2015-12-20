// наследуем класс Instrument графическим файлом
class Piano extends Instrument {
    private String company;

    // создаем конструктор
    public Piano(String n, String s, String p) {
        name = n;
        sound = s;
        company = p;
    }

}