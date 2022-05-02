package lesson8.birds;

public class Duck extends Bird {

    public Duck(int size, String color, String nest, int id) {
        super("Утка", size, color, nest, id);
    }

    @Override
    public void voice() {
        System.out.println("кря-кря");
    }
}
