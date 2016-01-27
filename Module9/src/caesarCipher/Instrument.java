package caesarCipher;

public class Instrument {
    protected String name;
    protected int price;

    public Instrument(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Instrument(String name) {
        this.name = name;
    }

    public Instrument(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}


