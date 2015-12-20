public class Instruments {
    public static void main(String[] args) {

        class Instrument {
            //агрегация с магазином
            Shop instr1 = new Shop("Guitar", 100);
            Shop instr2 = new Shop("Trumpet", 200);
            Shop instr3 = new Shop("Piano", 500);

            protected String name;
            protected String sound;

        }


            // наследуем класс Instrument классом гитара
             class Guitar extends Instrument {
                private String quantityOfStrings;

                // создаем конструктор
                public Guitar(String n, String s, String p) {
                    name = n;
                    sound = s;
                    quantityOfStrings = p;
                }

            }

            // наследуем класс Instrument аудиофайлом
             class Trumpet extends Instrument {
                private String color;

                // создаем конструктор
                public Trumpet(String n, String s, String p) {
                    name = n;
                    sound = s;
                    color = p;
                }

            }

            // наследуем класс Instrument графическим файлом
             class Piano extends Instrument {
                private String company;

                // создаем конструктор
                public Piano(String n, String s, String p) {
                    name = n;
                    sound = s;
                    company = p;
                }

            }

        }
    }