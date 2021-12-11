package lesson11;

import java.util.List;

public class BlockPostRunner {

    public static void main(String[] args) {
        List<Automobile> automobiles;
        try {
            Traffic traffic = new Traffic();
            automobiles = traffic.createTraffic(10);
            BlockPost.throughBlocPost(RoadToBlockPost.toBlockPost(automobiles));
            for (Automobile auto : automobiles) {
                System.out.println("-----------------");
                System.out.println(auto + ", проехал через КПП");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Дорога пустая, машин нет.");
        } catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так -> " + ex.getMessage());
        }
    }
}
