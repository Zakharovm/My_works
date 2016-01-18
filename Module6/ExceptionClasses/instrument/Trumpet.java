package ExceptionClasses.instrument;

// наследуем класс Instrument классом труба
public class Trumpet extends Instrument {
    private final int PRICE = 150;
    public Trumpet(String name, int price) {
        super(name,price);
    }
    public Trumpet (String name) {
        super(name);
    }
    public Trumpet (int price) {
        super(price);
    }
}