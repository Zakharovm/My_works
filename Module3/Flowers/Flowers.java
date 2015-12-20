public class Flowers {
    public static void main(String[] args) {


        //композиция букета из цветов
         class Bouquet {
            private String typeOfFlower;

            Flower Rose = new Flower();
            Flower Tulip = new Flower();
            Flower Camomile = new Flower();
            Flower Aster = new Flower();

            public void DoSomething() {

            }
        }

        //композиция куста из роз
        class Bush {
            private int Quantity;

            Rose flower = new Rose("Роза душистая","месяц","Розовые");


            public void DoSomething() {

            }
        }
    }
}