package lesson10;

public final class ThermometerAtCelsius extends Thermometer {

    public ThermometerAtCelsius() {
        this.type = Temperature.CELSIUS.getType();
    }

    public void convertTemperature(double value, Temperature fromTemp, Temperature toTemp) {
        if (fromTemp != Temperature.CELSIUS & toTemp != Temperature.CELSIUS) {
            System.out.println("Некорректное значение единиц измерения");
            return;
        }
        double convert = 0;
        System.out.printf("Конвернтирую значение температуры из %s в %s...\n", fromTemp.getType(), toTemp.getType());
        if (toTemp == Temperature.CELSIUS) {
            switch (fromTemp) {
                case CELSIUS -> convert = value;
                case KELVIN -> convert = value - 273.15;
                case FAHRENHEIT -> convert = ((value - 32) / 1.8);
            }
        } else {
            switch (toTemp) {
                case KELVIN -> convert = value + 273.15;
                case FAHRENHEIT -> convert = value * 1.8 + 32;
            }
        }
        System.out.printf("Конвертация окончена. %+.2f%s = %+.2f%s\n",
                value, fromTemp.getType(), convert, toTemp.getType());
    }
}
