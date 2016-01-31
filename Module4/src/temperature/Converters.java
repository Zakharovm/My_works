package temperature;

public class Converters {

    // Result = ((9*x)/5)+32  из Цельсия в Фаренгейты
    public double celsiusToFahrenheit(float celsius) {
        return 32 + ((9 * celsius) / 5);
    }

    // Result = (x-32)*5/9  из Фаренгейтов в Цельсии
    public double fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
