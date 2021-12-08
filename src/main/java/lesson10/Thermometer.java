package lesson10;

public abstract class Thermometer implements TemperatureConvertible {

    String type;
    double value;
    double convert;

    public Thermometer() {

    }

    public Thermometer measureTemp(double value) {
        this.value = value;
        return this;
    }

    public String toString() {
        return value + type;
    }
}
