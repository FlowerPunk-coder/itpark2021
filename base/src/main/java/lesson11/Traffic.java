package lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Traffic {

    private List<Automobile> traffic;
    private final static int MIN = 2;

    public Traffic() {

    }

    public List<Automobile> createTraffic(int count) {
        traffic = new ArrayList<>();
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < count; i++) {
            traffic.add(createAuto());
        }
        return traffic;
    }

    public Automobile createAuto() {
        Automobile auto = (new Random().nextBoolean()) ? new Car() : new Truck();
        auto.weight = (auto instanceof Car) ? new Random().nextInt(3) + MIN : new Random().nextInt(13) + MIN;
        auto.length = (auto instanceof Car) ? new Random().nextInt(3) + MIN : new Random().nextInt(13) + MIN;
        auto.high = (auto instanceof Car) ? new Random().nextInt(2) + MIN : new Random().nextInt(3) + MIN;
        auto.width = (auto instanceof Car) ? new Random().nextInt(1) + MIN : new Random().nextInt(2) + MIN;
        return auto;
    }

}
