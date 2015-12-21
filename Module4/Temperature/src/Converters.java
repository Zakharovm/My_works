public class Converters {

    // Result = ((9*x)/5)+32  из Цельсия в Фаренгейты
    public double celsiusToFahrenheit(float Celsius) {
        return 32+((9*Celsius)/5);
    }

    // Result = (x-32)*5/9  из Фаренгейтов в Цельсии
    public double fahrenheitToCelsius(float Fahrenheit) {
        return (Fahrenheit-32)*5/9;
    }
}
