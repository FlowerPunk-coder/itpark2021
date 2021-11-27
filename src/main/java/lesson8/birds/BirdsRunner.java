package lesson8.birds;

public class BirdsRunner {

    public static void main(String[] args) {
        Bird sparrow = new Sparrow(1, "коричнево-серый", "кустарник", 1);
        Bird crow = new Crow(2, "черный", "кроны деревьев", 1);
        Duck duck = new Duck(3, "серо-зеленая", "берега рек", 1 );
        Bird[] birds = new Bird[]{sparrow, crow, duck};
        for (Bird bird: birds) {
            System.out.print(bird.toString() + " ");
            bird.voice();
        }
    }
}
