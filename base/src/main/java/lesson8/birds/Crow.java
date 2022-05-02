package lesson8.birds;

public class Crow extends Bird {

    public Crow(int size, String color, String nest, int id) {
        super("Ворона", size, color, nest, id);
    }

    @Override
    public void voice() {
        System.out.println("каррр, каррр");
    }
}
