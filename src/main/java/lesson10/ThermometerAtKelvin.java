package lesson10;

public final class ThermometerAtKelvin extends Thermometer {

    public ThermometerAtKelvin() {
        this.type = Temperature.KELVIN.getType();
    }

    @Override
    public void convertTemperature(Temperature fromTemp, Temperature toTemp) {
        if (!isType(fromTemp, toTemp)) {
            return;
        }
        System.out.printf("Конвернтирую значение температуры из %s в %s...\n", fromTemp.getType(), toTemp.getType());
        if (toTemp == Temperature.KELVIN) {
            switch (fromTemp) {
                case KELVIN -> convert = value;
                case CELSIUS -> convert = value + CELSIUS_VALUE;
                case FAHRENHEIT -> convert = ((value + KELVIN_VALUE) / MULTI_VALUE);
            }
        } else {
            switch (toTemp) {
                case CELSIUS -> convert = value - CELSIUS_VALUE;
                case FAHRENHEIT -> convert = ((value * MULTI_VALUE) - KELVIN_VALUE);
            }
        }
        System.out.printf("Конвертация окончена. %+.2f%s = %+.2f%s\n",
                value, fromTemp.getType(), convert, toTemp.getType());
    }

    private boolean isType(Temperature fromTemp, Temperature toTemp) {
        if (fromTemp != Temperature.KELVIN & toTemp != Temperature.KELVIN) {
            System.out.println("Некорректное значение единиц измерения");
            return false;
        }
        return true;
    }
}
