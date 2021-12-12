package lesson11;

import lesson11.exept.MaxSpeedException;
import lesson11.inter.Road;

import java.util.ArrayList;
import java.util.List;

public class TrafficPolice {

    private List<Automobile> violators = new ArrayList<>();
    private int allowedSpeed;
    private int maxSpeed;

    public TrafficPolice(Road road) {
       this.allowedSpeed = road.getAllowedSpeed();
       this.maxSpeed = road.getMaxSpeed();
    }

    public boolean controlSpeed(Automobile auto) throws InterruptedException {
        String message = "разогнался до скорости ";
        Thread.sleep(150);
        try {
            checkSpeed(auto.acceleration());
        } catch (MaxSpeedException ex) {
            if (auto.speed > maxSpeed) {
                System.out.printf(message + "%d км/ч, полиция выехала на задержание...\n", auto.speed);
                detain(auto);
                return false;
            }
            System.out.printf(message + "%d км/ч, превышая максимально допустимую скорость", auto.speed);
            return true;
        }
        System.out.print(message + auto.speed + " км/ч");
        return true;
    }

    public int checkSpeed(int speed) {
        if (speed > allowedSpeed) {
            throw new MaxSpeedException();
        }
        return speed;
    }

    public void detain(Automobile auto) {
        System.out.println("Дорожный патруль задержал автомобиль нарушителя: " + auto.toString());
        violators.add(auto);
    }

    public List<Automobile> getViolators() {
        return violators;
    }
}
