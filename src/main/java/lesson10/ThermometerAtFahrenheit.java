package lesson10;

public final class ThermometerAtFahrenheit extends Thermometer {


    public ThermometerAtFahrenheit() {
        this.type = Temperature.FAHRENHEIT.getType();
    }

    public void convertTemperature(double value, Temperature fromTemp, Temperature toTemp) {
        if (fromTemp != Temperature.FAHRENHEIT & toTemp != Temperature.FAHRENHEIT) {
            System.out.println("Некорректное значение единиц измерения");
            return;
        }
        double convert = 0;
        System.out.printf("Конвернтирую значение температуры из %s в %s...\n", fromTemp.getType(), toTemp.getType());
        if (toTemp == Temperature.FAHRENHEIT) {
            switch (fromTemp) {
                case FAHRENHEIT -> convert = value;
                case CELSIUS -> convert = value * 1.8 + 32;
                case KELVIN -> convert = value * 1.8 - 459.67;
            }
        } else {
            switch (toTemp) {
                case CELSIUS -> convert = (value - 32) / 1.8;
                case KELVIN -> convert = ((value + 459.67) / 1.8);
            }
        }
        System.out.printf("Конвертация окончена. %+.2f%s = %+.2f%s\n",
                value, fromTemp.getType(), convert, toTemp.getType());
    }
}
