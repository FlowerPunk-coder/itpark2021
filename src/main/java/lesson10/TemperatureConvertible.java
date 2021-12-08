package lesson10;

public interface TemperatureConvertible {
    
    double MULTI_VALUE = 1.8;
    double CELSIUS_VALUE = 273.15;
    double KELVIN_VALUE = 459.67;
    int FAHRENHEIT_VALUE = 32;

    void convertTemperature(Temperature fromTemperature, Temperature toTemperature);
    
}
