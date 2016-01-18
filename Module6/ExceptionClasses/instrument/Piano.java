package ExceptionClasses.instrument;

// наследуем класс Instrument классом пианино
public class Piano extends Instrument {
    private final int PRICE = 200;
    public Piano(String name, int price) {
        super(name,price);
    }

    public Piano (String name) {
        super(name);
    }
    public Piano (int price) {
        super(price);
    }
}