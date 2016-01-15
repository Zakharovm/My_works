package existingExceptionClass.flower;

//композиция букета из цветов
public class Bouquet {

    private Flower[] flowerBouquet = {new Rose(), new Aster(), new Camomile(), new Tulip()};

    public void create(int quantityOfFlowers) throws NegativeArraySizeException {
        if (quantityOfFlowers < 0) {
            throw new NegativeArraySizeException();
        }
        else {
            Flower[] bouquet = new Flower[quantityOfFlowers];
        }
    }

    public Bouquet(Flower[] flowerBouquet) {
        this.flowerBouquet = flowerBouquet;
    }

}

