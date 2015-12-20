
        class Flower {
            protected String name;
            protected String age;

        }


// наследуем класс Flower классом роза
        class Rose extends Flower {
            private String family;

            // создаем конструктор
            public Rose(String n, String s, String p) {
                name = n;
                age = s;
                family = p;
            }
        }

// наследуем класс Flower классом ромашка
        class Camomile extends Flower {
            private String color;

            // создаем конструктор
            public Camomile(String n, String s, String p) {
                name = n;
                age = s;
                color = p;
            }
        }

        // наследуем класс Flower классом астра
        class Aster extends Flower {
            private String size;

            // создаем конструктор
            public Aster(String n, String s, String p) {
                name = n;
                age = s;
                size = p;
            }
        }

        // наследуем класс Flower классом тюльпан
        class Tulip extends Flower {
            private String length;

            // создаем конструктор
            public Tulip(String n, String s, String p) {
                name = n;
                age = s;
                length = p;
            }

        }



