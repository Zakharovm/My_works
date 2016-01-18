package ExceptionClasses.instrument;

// наследуем класс Instrument классом гитара
public class Guitar extends Instrument {
    private final int PRICE = 100;
    public Guitar(String name, int price) {
        super(name,price);
    }
    public Guitar (String name) {
        super(name);
    }
    public Guitar (int price) {
        super(price);
    }

}