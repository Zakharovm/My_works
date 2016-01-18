package ExceptionClasses.instrument;

public class Shop {

    private Instrument[] instrumentArray = new Instrument[3];

    public Shop(Instrument[] instrumentArray) {
        this.instrumentArray = instrumentArray;
    }

    public void sellInstrument(int quantity) throws ArrayIndexOutOfBoundsException {
        if (quantity > instrumentArray.length) {
            throw new ArrayIndexOutOfBoundsException(quantity);
        }
    }

    public int countPrice(String instrumentName, int cash, int quantity) throws NotEnoughMoneyException {
        int price = 0;
        for (int i = 0; i < instrumentArray.length; i++) {
            if (instrumentName.equals(instrumentArray[i].getName())) {
                price = instrumentArray[i].getPrice();
                break;
            } else if (i == instrumentArray.length - 1) {
                System.out.println("There is no such instrument");
            }
        }
        int sum = quantity * price - cash;

        if (sum > 0) {
            throw new NotEnoughMoneyException(sum);
        }
        return cash - Math.abs(sum);
    }

}

