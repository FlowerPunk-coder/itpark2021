package lesson10;

public final class ThermometerAtFahrenheit extends Thermometer {


    public ThermometerAtFahrenheit() {
        this.type = Temperature.FAHRENHEIT.getType();
    }

    public void convertTemperature(Temperature fromTemp, Temperature toTemp) {
        if (!isType(fromTemp, toTemp)) {
            return;
        }
        System.out.printf("Конвернтирую значение температуры из %s в %s...\n", fromTemp.getType(), toTemp.getType());
        if (toTemp == Temperature.FAHRENHEIT) {
            switch (fromTemp) {
                case FAHRENHEIT -> convert = value;
                case CELSIUS -> convert = value * MULTI_VALUE + FAHRENHEIT_VALUE;
                case KELVIN -> convert = value * MULTI_VALUE - KELVIN_VALUE;
            }
        } else {
            switch (toTemp) {
                case CELSIUS -> convert = (value - FAHRENHEIT_VALUE) / MULTI_VALUE;
                case KELVIN -> convert = ((value + KELVIN_VALUE) / MULTI_VALUE);
            }
        }
        System.out.printf("Конвертация окончена. %+.2f%s = %+.2f%s\n",
                value, fromTemp.getType(), convert, toTemp.getType());
    }

    private boolean isType(Temperature fromTemp, Temperature toTemp) {
        if (fromTemp != Temperature.FAHRENHEIT & toTemp != Temperature.FAHRENHEIT) {
            System.out.println("Некорректное значение единиц измерения");
            return false;
        }
        return true;
    }
}
