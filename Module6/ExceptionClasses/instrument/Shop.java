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

    public int countPtice(String instrumentName, int cash, int quantity) throws NotEnoughMoneyException {
        int sum = 0;
        switch (instrumentName) {
            case "Guitar":
                sum = quantity*100 - cash;
                if (sum > 0) {
                    throw new NotEnoughMoneyException(sum);
                }
                break;
            case "Piano":
                sum = quantity*200 - cash;
                if (sum > 0) {
                    throw new NotEnoughMoneyException(sum);
                }
                break;
            case "Trunpet":
                sum = quantity*150 - cash;
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
