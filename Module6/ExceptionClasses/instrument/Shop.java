package ExceptionClasses.instrument;

public class Shop {
    public static final int TRUMPET_PRICE = 150;
    public static final int PIANO_PRICE = 200;
    public static final int GUITAR_PRICE = 100;
    private Instrument[] instrumentArray = new Instrument[3];

    public Shop(Instrument[] instrumentArray) {
        this.instrumentArray = instrumentArray;
    }

    public void sellInstrument(int quantity) throws ArrayIndexOutOfBoundsException {
        if (quantity > instrumentArray.length) {
            throw new ArrayIndexOutOfBoundsException(quantity);
        }

    }

    public int countPtice(String instrumentName, int cash, int quantity) throws NotEnoughMoneyException {
        int sum = 0;
        switch (instrumentName) {
            case "Guitar":
                sum = quantity * GUITAR_PRICE - cash;
                if (sum > 0) {
                    throw new NotEnoughMoneyException(sum);
                }
                break;
            case "Piano":
                sum = quantity * PIANO_PRICE - cash;
                if (sum > 0) {
                    throw new NotEnoughMoneyException(sum);
                }
                break;
            case "Trumpet":
                sum = quantity * TRUMPET_PRICE - cash;
                if (sum > 0) {
                    throw new NotEnoughMoneyException(sum);
                }
                break;
            default:
                System.out.println("There is no such instrument");
        }
        return cash - Math.abs(sum);
    }

}
