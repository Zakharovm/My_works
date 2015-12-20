// наследуем класс Instrument классом гитара
class Guitar extends Instrument {
    private String quantityOfStrings;

    // создаем конструктор
    public Guitar(String n, String s, String p) {
        name = n;
        sound = s;
        quantityOfStrings = p;
    }

}