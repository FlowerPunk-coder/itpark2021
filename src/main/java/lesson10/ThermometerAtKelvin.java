package lesson10;

public final class ThermometerAtKelvin extends Thermometer {

    public ThermometerAtKelvin() {
        this.type = Temperature.KELVIN.getType();
    }

    @Override
    public void convertTemperature(double value, Temperature fromTemp, Temperature toTemp) {
        if (fromTemp != Temperature.KELVIN & toTemp != Temperature.KELVIN) {
            System.out.println("Некорректное значение единиц измерения");
            return;
        }
        double convert = 0;
        System.out.printf("Конвернтирую значение температуры из %s в %s...\n", fromTemp.getType(), toTemp.getType());
        if (toTemp == Temperature.KELVIN) {
            switch (fromTemp) {
                case KELVIN -> convert = value;
                case CELSIUS -> convert = value + 273.15;
                case FAHRENHEIT -> convert = ((value + 459.67) / 1.8);
            }
        } else {
            switch (toTemp) {
                case CELSIUS -> convert = value - 273.15;
                case FAHRENHEIT -> convert = ((value * 1.8) - 459.67);
            }
        }
        System.out.printf("Конвертация окончена. %+.2f%s = %+.2f%s\n",
                value, fromTemp.getType(), convert, toTemp.getType());
    }
}
