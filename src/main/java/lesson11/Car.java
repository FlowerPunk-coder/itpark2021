package lesson11;

import java.util.Random;

public final class Car extends Automobile {

    public Car() {
        super();
        this.type = "Легковой";
    }

    @Override
    public int acceleration() {
        return speed = new Random().nextInt(201);
    }
}
