public class Convert {
    public static void main(String[] args) {
        Celsius n1 = new Celsius(20);           //Число в Цельсиях, которое конвертируется
        Fahrenheit r1 = new Fahrenheit(68);     //Число в Фаренгейтах, которое конвертируется

        System.out.println("Convert from Celsius to Fahrenheit: " + new Translation().celToFer(n1));
        System.out.println("Convert from Fahrenheit to Celsius: " + new Translation().ferToCel(r1));
    }
}

