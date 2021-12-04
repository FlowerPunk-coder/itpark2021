package lesson10;

public class ConverterLauncher {

    public static void main(String[] args) {
        Thermometer thermK = new ThermometerAtKelvin();
        Thermometer thermC = new ThermometerAtCelsius();
        Thermometer thermF = new ThermometerAtFahrenheit();
        thermF.convertTemperature(45, Temperature.CELSIUS, Temperature.FAHRENHEIT);
        thermC.convertTemperature(45, Temperature.CELSIUS, Temperature.KELVIN);
        thermK.convertTemperature(45, Temperature.FAHRENHEIT, Temperature.KELVIN);
    }
}
