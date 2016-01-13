package existingExceptionClass.flower;

//композиция букета из цветов
public class Bouquet {

    private Flower[] flowerBouquet = {new Rose(), new Aster(), new Camomile(), new Tulip()};

    public Bouquet(Flower[] flowerBouquet) {
        this.flowerBouquet = flowerBouquet;
    }

}

