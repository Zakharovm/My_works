public class Translation {

    // Result = ((9*x)/5)+32  из Цельсия в Фаренгейты
    public double celToFer(Celsius c) {
        double r = 32+((9*c.getA())/5);
        return r;
    }

    // Result = (x-32)*5/9  из Фаренгейтов в Цельсии
    public double ferToCel(Fahrenheit f) {
        double r = (f.getA()-32)*5/9;
        return r;
    }
}
