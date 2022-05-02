package lesson8.birds;

public class Sparrow extends Bird {


    public Sparrow(int size, String color, String nest, int id) {
        super("Воробей", size, color, nest, id);
    }

    @Override
    public void voice() {
        System.out.println("чик-чирик");
    }
}
