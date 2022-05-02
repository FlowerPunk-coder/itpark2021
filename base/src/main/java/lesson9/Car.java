package lesson9;

public final class Car extends Automobile {

    private int maxSpeed;

    public Car(String carBrand, String model, String color, String type, Fuel fuel, int power, int maxSpeed) {
       super(carBrand, model, color, type, fuel, power);
       this.maxSpeed = maxSpeed;
    }

    @Override
    public void move(int n) {
        System.out.println("начал движение..");
        if (n > 0 & n <= 500) {
            System.out.println("и проехал " + n + " километров");
        } else if (n > 500) {
            System.out.println("проехал 500 километров и заглох...");
            if (fuel == Fuel.DIESEL) {
                System.out.println("...дизель закончился");
            } else {
                System.out.println("...бензин закончился");
            }
        } else {
            System.out.println("задним ходом");
        }
    }
}
