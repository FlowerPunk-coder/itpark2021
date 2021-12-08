package lesson10;

public class ConverterLauncher {

    public static void main(String[] args) {
        Thermometer thermK = new ThermometerAtKelvin();
        Thermometer thermC = new ThermometerAtCelsius();
        Thermometer thermF = new ThermometerAtFahrenheit();
        thermF.measureTemp(23);
        thermC.measureTemp(42);
        thermK.measureTemp(43.5874);
        thermF.convertTemperature(Temperature.CELSIUS, Temperature.FAHRENHEIT);
        thermC.convertTemperature(Temperature.CELSIUS, Temperature.KELVIN);
        thermK.convertTemperature(Temperature.FAHRENHEIT, Temperature.KELVIN);
        System.out.println(thermK);
        thermC.measureTemp(24).convertTemperature(Temperature.CELSIUS, Temperature.FAHRENHEIT);
    }
}
