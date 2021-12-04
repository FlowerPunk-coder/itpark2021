package lesson10;

public abstract class Thermometer implements TemperatureConvertible {

    String type;
    double value;

    public Thermometer() {

    }

    public void measureTemp(double value) {
        this.value = value;
        System.out.printf("Измеренная температура равна %+.2f%s", value, type);
    }
}
