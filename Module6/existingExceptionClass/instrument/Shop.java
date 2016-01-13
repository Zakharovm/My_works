package existingExceptionClass.instrument;

public class Shop {
    private Instrument[] instrumentArray = new Instrument[5];

    public Shop(Instrument[] instrumentArray) {
        this.instrumentArray = instrumentArray;
    }

    public void sellInstrument(int quantity) throws ArrayIndexOutOfBoundsException  {
        if (quantity > instrumentArray.length) {
            throw new ArrayIndexOutOfBoundsException(quantity);
        }

    }

}
