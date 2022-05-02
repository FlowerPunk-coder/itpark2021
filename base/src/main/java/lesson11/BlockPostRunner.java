package lesson11;

import java.util.List;

public class BlockPostRunner {

    public static void main(String[] args) {
        List<Automobile> automobiles;
        try {
            Traffic traffic = new Traffic();
            RoadToBlockPost road = new RoadToBlockPost();
            BlockPost post = new BlockPost(8, 4, 2.5);
            automobiles = traffic.createTraffic(10);
            post.throughBlockPost(road.toBlockPost(automobiles));
            for (Automobile auto : automobiles) {
                System.out.println("----------------------");
                System.out.println(auto + ", проехал через КПП");
            }
            System.out.println("----------------------");
            System.out.println(automobiles.size() + " автомобилей проехало через КПП");
        } catch (IllegalArgumentException ex) {
            System.out.println("Дорога пустая, машин нет.");
        } catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так -> " + ex.getMessage());
        }
    }
}
