package lesson11;

import lesson11.exept.MaxDimensionsException;
import lesson11.exept.MaxWeightException;

import java.util.ArrayList;
import java.util.List;

public class BlockPost {

    private final int maxWeight;
    private final int maxHigh;
    private final double maxWidth;
    private List<Automobile> overSizes;

    public BlockPost(int maxWeight, int maxHigh, double maxWidth) {
        this.maxWeight = maxWeight;
        this.maxHigh = maxHigh;
        this.maxWidth = maxWidth;
    }

    public List<Automobile> throughBlockPost(List<Automobile> traffic) throws InterruptedException {
        overSizes = new ArrayList<>();
        for (Automobile auto : traffic) {
            Thread.sleep(150);
            System.out.println("----------------------");
            System.out.println(auto + ", въезжает на КПП для прохождения проверок...");
            try {
                checkWeight(auto);
                checkDimensions(auto);
            }catch (MaxWeightException ex) {
                System.out.printf("%s, не прошел проверку разрешенного веса %dт. Вес данного автомобиля состовляет: %dт\n",
                        auto, maxWeight, auto.weight);
                overSizes.add(auto);
            }catch (MaxDimensionsException ex) {
                System.out.printf("%s, не прошел проверку разрешенных габаритов: " +
                                "ширина %.1f м, " +
                                "высота %d м. " +
                                "Габариты данного автомобиля состовляет: ширина: %d м, высота: %d м\n",
                                auto, maxWidth, maxHigh, auto.width, auto.high);
                overSizes.add(auto);
            }
        }
        System.out.println("----------------------");
        System.out.println(overSizes.size() + " автомобилей не смогли проехать через КПП");
        traffic.removeAll(overSizes);
        return traffic;
    }

    private void checkWeight(Automobile auto) {
        if (auto.weight > maxWeight) {
            throw new MaxWeightException();
        } else {
            System.out.printf("%s, прошел проверку веса (%dт)\n",
                    auto, auto.weight);
        }
    }

    private void checkDimensions(Automobile auto) {
        if (auto.width > maxWidth | auto.high > maxHigh) {
            throw new MaxDimensionsException();
        } else {
            System.out.printf("%s, прошел проверку габаритов (ширина: %d м, высота: %d м) и может проезжать\n",
                    auto, auto.width, auto.high);
        }
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMaxHigh() {
        return maxHigh;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public List<Automobile> getOverSizes() {
        return overSizes;
    }
}
