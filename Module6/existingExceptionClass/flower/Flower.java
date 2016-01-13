package existingExceptionClass.flower;

public class Flower {

    public void createBouquet(int quantityOfFlowers) throws NegativeArraySizeException {
        if (quantityOfFlowers < 0) {
            throw new NegativeArraySizeException();
        }
        else {
            Flower[] bouquet = new Flower[quantityOfFlowers];
        }
    }

}






