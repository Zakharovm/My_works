public class Flowers {
    public static void main(String[] args) {
public class Flower {
        protected String name;
        protected String species;
        public void setName(String newName){
            name = newName;
        }
        public String getName(){
            return name;
        }
        public void setSpecies(String newSpecies){
            name = newSpecies;
        }
        public String getSpecies(){
            return species;
        }
    }
}

// наследуем класс Flower классом роза
public class Rose extends Flower {
    private String family;
    // создаем и конструктор
    public Rose(String n, String s, String p) {
        name = n;
        species = s;
        family = p;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
}

// наследуем класс Flower классом ромашка

public class Camomile extends Flower {
    private String color;
    // создаем и конструктор
    public Camomile(String n, String s, String p) {
        name = n;
        species = s;
        color = p;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }

}// наследуем класс Flower классом астра

public class Aster extends Flower {
    private String size;
    // создаем и конструктор
    public Aster(String n, String s, String p) {
        name = n;
        species = s;
        size = p;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }

}// наследуем класс Flower классом тюльпан
public class Tulip extends Flower {
    private String age;
    // создаем и конструктор
    public Tulip (String n, String s, String p) {
        name = n;
        species = s;
        age = p;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
}

//композиция букета из цветов
public class Bouquet {
    private int size;


    private Set flowers = new HashSet();
    public Bouquet (int f) {
        size = f;
    }

    public void addFlower(Flower newFlower){
        flowers.add(newFlower);
        // связываем цветок с букетом
        newFlower.setBouquet(this);
    }
    public Set getFlower(){
        return flowers;
    }
    public void removeFlower(Flower e){
        flowers.remove(e);
    }

}

//композиция куста из роз
public class Bush {
    private int size;


    private Set roses = new HashSet();
    public Bush (int f) {
        size = f;
    }

    public void addRose(Rose newRose){
        roses.add(newRose);
        // связываем розу с кустом
        newRose.setBush(this);
    }
    public Set getRose(){
        return roses;
    }
    public void removeRose(Rose e){
        roses.remove(e);
    }

}
}
