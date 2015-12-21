public class Shop {
    Instrument guitar = new Guitar();
    Instrument piano = new Piano();
    Instrument trumpet = new Trumpet();


    public Shop (Instrument guitar, Instrument piano, Instrument trumpet) {
        this.guitar = guitar;
        this.piano = piano;
        this.trumpet = trumpet;
    }
}
