// наследуем класс Flower классом роза
class Rose extends Flower {
    private String family;

    // создаем конструктор
    public Rose(String n, String s, String p) {
        name = n;
        age = s;
        family = p;
    }
}