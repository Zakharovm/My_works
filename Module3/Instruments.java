public class Instruments {
    public static void main(String[] args) {
public class Instrument {
    protected String name;
    protected String sound;
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
    public void setSound(String newSound){
        name = newSound;
    }
    public String gextSound(){
        return sound;
    }

    private Shop shop;

    public void setShop(Shop d){
        shop = d;
    }
    public Shop getShop(){
        return shop;
    }


    // наследуем класс Instrument классом гитара
    public class Guitar extends Instrument {
        private String quantity_of_strings;
        // создаем и конструктор
        public Guitar(String n, String s, String p) {
            name = n;
            sound = s;
            quantity_of_strings = p;
        }
        public void getName(){

            return name;
        }
        public String getQuantity_of_strings(){

            return quantity_of_strings;
        }
    }

    // наследуем класс Instrument аудиофайлом
    public class Trumpet extends Instrument {
        private String color;
        // создаем и конструктор
        public Trumpet(String n, String s, String p) {
            name = n;
            sound = s;
            color = p;
        }
        public void getName(){
            return name;
        }
        public String getColor(){
            return color;
        }
    }

    // наследуем класс Instrument графическим файлом
    public class Piano extends Instrument {
        private String company;
        // создаем и конструктор
        public Piano(String n, String s, String p) {
            name = n;
            sound = s;
            company = p;
        }
        public void getName(){
            return name;
        }
        public String getCompany(){
            return company;
        }
    }

    //агрегация магазина и инструментов
    public class Shop {
        private String name;
        private String address;
        private Set instruments = new HashSet();
        public Shop (String f, String k) {
            name = f;
            address=k;
        }

        public void addInstrument(Instrument newInstrument){
            instruments.add(newInstrument);
            // связываем инструмент с магазином
            newInstrument.setShop(this);
        }
        public Set getInstrument(){
            return instruments;
        }
        public void removeFile(Instrument e){
            instruments.remove(e);
        }
    }
}
