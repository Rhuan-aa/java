package temperature;

public class StandardTemperatureConversor implements TemperatureConversor{

    @Override
    public double fahrenheitToCelcius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    @Override
    public double celciusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
