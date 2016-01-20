package ExceptionClasses.flower;


public class WrongNumberOfFlowers extends Exception {
    private int quantityOfFlowers;

    public WrongNumberOfFlowers(int quantityOfFlowers) {
        this.quantityOfFlowers = quantityOfFlowers;
    }

    public int getQuantityOfFlowers() {
        return quantityOfFlowers;
    }
}
