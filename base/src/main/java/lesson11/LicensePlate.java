package lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LicensePlate {

    private String licensePlate;
    private static List<String> licensePlateArr = new ArrayList<>();
    private final char[] symbols = {'A', 'B', 'C', 'E', 'H', 'K',
            'M', 'O', 'P', 'T', 'X'};

    public LicensePlate() {
        createLicensePlate();
    }

    private void createLicensePlate() {
        while (true) {
            StringBuilder temp = new StringBuilder();
            temp.append(getSymbol())
                    .append(" ")
                    .append(getNumber())
                    .append(getNumber())
                    .append(getNumber())
                    .append(" ")
                    .append(getSymbol())
                    .append(getSymbol())
                    .append(" ")
                    .append(getRegion());
            licensePlate = temp.toString();
            if (!licensePlateArr.contains(licensePlate)) {
                licensePlateArr.add(licensePlate);
                break;
            }
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    private char getSymbol() {
        return symbols[new Random().nextInt(11)];
    }

    private int getNumber() {
        return new Random().nextInt(10);
    }

    private String getRegion() {
        while (true) {
            StringBuilder reg = new StringBuilder();
            reg.append(getNumber())
                    .append(getNumber());
            if (!reg.equals("00") || !reg.equals("20")) {
                return reg.toString();
            }
        }
    }
}
