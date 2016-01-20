package ExceptionClasses.flower;


public class Bouquet {
    private Flower[] flowerBouquet = new Flower[4];

    public Bouquet(Flower[] flowerBouquet) {
        this.flowerBouquet = flowerBouquet;
    }

    public void create(int quantityOfFlowers) throws NegativeArraySizeException {
        if (quantityOfFlowers < 0) {
            throw new NegativeArraySizeException();
        }
        else {
            Flower[] flowerBouquet = new Flower[quantityOfFlowers];
        }
    }
}
