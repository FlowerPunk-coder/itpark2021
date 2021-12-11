package lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LicensePlate {

    private int licensePlate;
    private static List<Integer> licensePlateArr = new ArrayList<>();

    public LicensePlate() {
        createLicensePlate();
    }

    private void createLicensePlate() {
        licensePlate = new Random().nextInt(1_000);
        while (true) {
            if (!licensePlateArr.contains(licensePlate)) {
                licensePlateArr.add(licensePlate);
                break;
            }
            licensePlate = new Random().nextInt(1_000);
        }
    }

    public int getLicensePlate() {
        return licensePlate;
    }
}
