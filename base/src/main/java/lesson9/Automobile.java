package lesson9;

public abstract class Automobile {

    String carBrand;
    String model;
    String color;
    String type;
    Fuel fuel;
    int power;

    public Automobile(String carBrand, String model, String color, String type, Fuel fuel, int power) {
        this.carBrand = carBrand;
        this.model = model;
        this.color = color;
        this.type = type;
        this.fuel = fuel;
        this.power = power;
    }

    @Override
    public String toString() {
        System.out.println("------------------");
        return color + " " + carBrand + " " + type;
    }

    public abstract void move(int n);
}
