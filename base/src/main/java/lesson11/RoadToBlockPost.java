package lesson11;

import lesson11.inter.Highway;

import java.util.List;

public class RoadToBlockPost implements Highway {

    public RoadToBlockPost() {

    }

    public  List<Automobile> toBlockPost(List<Automobile> traffic) throws InterruptedException {
        TrafficPolice patrolCar = new TrafficPolice(this);
        for (Automobile auto : traffic) {
            System.out.println("----------------------");
            System.out.printf("%s, двигается в сторону КПП..\n", auto);
            Thread.sleep(150);
            if (patrolCar.controlSpeed(auto)) {
                System.out.println(", добрался до КПП");
            }
        }
        traffic.removeAll(patrolCar.getViolators());
        System.out.println("----------------------");
        System.out.println(traffic.size() + " автомобилей добралось до КПП");
        System.out.println(patrolCar.getViolators().size() + " автомобилей задержанно дорожной полицией");
        return traffic;
    }
}
