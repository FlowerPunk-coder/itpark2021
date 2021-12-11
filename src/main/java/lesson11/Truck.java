package lesson11;

import java.util.Random;

public class Truck extends Automobile {

    public Truck() {
        super();
        this.type = "Грузовой";
    }

    @Override
    public int acceleration() {
        return speed = new Random().nextInt(131);
    }
}
