// наследуем класс Instrument аудиофайлом
class Trumpet extends Instrument {
    private String color;

    // создаем конструктор
    public Trumpet(String n, String s, String p) {
        name = n;
        sound = s;
        color = p;
    }

}