package lesson10;

public final class ThermometerAtCelsius extends Thermometer {

    public ThermometerAtCelsius() {
        this.type = Temperature.CELSIUS.getType();
    }

    public void convertTemperature(Temperature fromTemp, Temperature toTemp) {
        if (!isType(fromTemp, toTemp)) {
            return;
        }

        System.out.printf("Конвернтирую значение температуры из %s в %s...\n", fromTemp.getType(), toTemp.getType());
        if (toTemp == Temperature.CELSIUS) {
            switch (fromTemp) {
                case CELSIUS -> convert = value;
                case KELVIN -> convert = value - CELSIUS_VALUE;
                case FAHRENHEIT -> convert = ((value - FAHRENHEIT_VALUE) / MULTI_VALUE);
            }
        } else {
            switch (toTemp) {
                case KELVIN -> convert = value + CELSIUS_VALUE;
                case FAHRENHEIT -> convert = value * MULTI_VALUE + FAHRENHEIT_VALUE;
            }
        }
        System.out.printf("Конвертация окончена. %+.2f%s = %+.2f%s\n",
                value, fromTemp.getType(), convert, toTemp.getType());
    }

    private boolean isType(Temperature fromTemp, Temperature toTemp) {
        if (fromTemp != Temperature.CELSIUS & toTemp != Temperature.CELSIUS) {
            System.out.println("Некорректное значение единиц измерения");
            return false;
        }
        return true;
    }
}
