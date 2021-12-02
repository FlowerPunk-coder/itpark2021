package lesson9;

public final class Truck extends Automobile {

    private double loadCapacity;

    public Truck(String carBrand, String model, String color, String type, Fuel fuel, int power, double loadCapacity) {
        super(carBrand, model, color, type, fuel, power);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void move(int n) {
        System.out.println("звелся...");
        if (n > 0 & n <= 1200) {
            System.out.println("начал движение и без остановки проехал " + n + " километров");
        } else if (n > 1200) {
            System.out.println("проехал долгий путь в 1200 километров и почти добрался до места назначения...");
            System.out.println("но дизель закончился.");
        } else {
            System.out.println("и сдает назад");
        }
    }
}
