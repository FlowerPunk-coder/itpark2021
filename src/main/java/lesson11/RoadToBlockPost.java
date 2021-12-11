package lesson11;

import lesson11.enums.SpecialType;
import lesson11.exept.MaxSpeedException;

import java.util.ArrayList;
import java.util.List;

public class RoadToBlockPost {

    private final static int MAX_SPEED = 80;
    private final static int MAX_SPEED_DETENTION = 100;

    public RoadToBlockPost() {

    }

    public static List<Automobile> toBlockPost(List<Automobile> traffic) throws InterruptedException {
        List<Automobile> violators = new ArrayList<>();
        for (Automobile auto : traffic) {
            System.out.println("---------------------");
            System.out.printf("%s, двигается в сторону КПП..\n", auto);
            Thread.sleep(150);
            if (!controlSpeed(auto)) {
                violators.add(auto);
            } else {
                System.out.println(", добрался до КПП");
            }
        }
        traffic.removeAll(violators);
        return traffic;

    }

    private static boolean controlSpeed(Automobile auto) throws InterruptedException {
        String message = "разогнался до скорости ";
        Thread.sleep(150);
        try {
            checkSpeed(auto.acceleration());
        } catch (MaxSpeedException ex) {
            if (auto.speed > MAX_SPEED_DETENTION) {
                System.out.printf(message + "%d км/ч, полиция выехала на задержание...\n", auto.speed);
                new SpecialCar(SpecialType.POLICE).detention(auto);
                return false;
            }
            System.out.printf(message + "%d км/ч, превышая максимально допустимую скорость", auto.speed);
            return true;
        }
        System.out.print(message + auto.speed + " км/ч");
        return true;
    }

    private static int checkSpeed(int speed) {
        if (speed > MAX_SPEED) {
            throw new MaxSpeedException();
        }
        return speed;
    }


}
