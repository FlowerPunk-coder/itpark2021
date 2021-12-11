package lesson11;

import lesson11.exept.MaxDimensionsException;
import lesson11.exept.MaxWeightException;

import java.util.ArrayList;
import java.util.List;

public class BlockPost {

    private final static int MAX_WEIGHT = 8;
    private final static int MAX_HIGH = 4;
    private final static double MAX_WIDTH = 2.5;

    public BlockPost() {

    }

    public static List<Automobile> throughBlocPost(List<Automobile> traffic) throws InterruptedException {
        List<Automobile> violators = new ArrayList<>();
        for (Automobile auto : traffic) {
            Thread.sleep(150);
            System.out.println("----------------------");
            System.out.println(auto + " въезжает на КПП для прохождения проверок...");
            try {
                checkWeight(auto);
                checkDimensions(auto);
            }catch (MaxWeightException ex) {
                System.out.printf("%s, не прошел проверку разрешенного веса %dт. Вес данного автомобиля состовляет: %dт\n",
                        auto, MAX_WEIGHT, auto.weight);
                violators.add(auto);
            }catch (MaxDimensionsException ex) {
                System.out.printf("%s, не прошел проверку разрешенных габаритов: " +
                                "ширина %.1f м, " +
                                "высота %d м. " +
                                "Габариты данного автомобиля состовляет: ширина: %d м, высота: %d м\n",
                                auto, MAX_WIDTH, MAX_HIGH, auto.width, auto.high);
                violators.add(auto);
            }
        }
        traffic.removeAll(violators);
        return traffic;
    }

    private static void checkWeight(Automobile auto) {
        if (auto.weight > MAX_WEIGHT) {
            throw new MaxWeightException();
        } else {
            System.out.printf("%s, прошел проверку веса (%dт)\n",
                    auto, auto.weight);
        }
    }

    private static void checkDimensions(Automobile auto) {
        if (auto.width > MAX_WIDTH | auto.high > MAX_HIGH) {
            throw new MaxDimensionsException();
        } else {
            System.out.printf("%s, прошел проверку габаритов (ширина: %d м, высота: %d м) и может проезжать\n",
                    auto, auto.width, auto.high);
        }
    }


}
