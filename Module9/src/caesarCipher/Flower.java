package caesarCipher;

public class Flower {
    protected String name;
    protected int size;

    public Flower(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return this.name;
    }

}






