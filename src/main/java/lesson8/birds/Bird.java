package lesson8.birds;

public class Bird {

    private String type;
    private int size;
    private String color;
    private String nest;
    private int id;


    public Bird(String type, int size, String color, String nest, int id) {
        this.type = type;
        this.size = size;
        this.color = color;
        this.nest = nest;
        this.id = id;
    }

    public void voice() {
        System.out.println("Разные птицы издают разные звуки");
    }

    @Override
    public String toString() {
        return type;
    }
}
