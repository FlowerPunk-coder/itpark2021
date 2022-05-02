package lesson11;

public abstract class Automobile {

    int speed, weight, high, width, length;
    String type, licensePlate;

    public Automobile() {
        this.licensePlate = new LicensePlate().getLicensePlate();
    }

    public abstract int acceleration();

    @Override
    public String toString() {
        return type + " автомобиль, гос. номер " + licensePlate;
    }
}
