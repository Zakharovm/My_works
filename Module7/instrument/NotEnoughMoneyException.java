package instrument;

public class NotEnoughMoneyException extends Exception{
    private int sum;

    public NotEnoughMoneyException(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}
