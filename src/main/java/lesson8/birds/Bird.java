package lesson8.birds;

public abstract class Bird {

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

    public abstract void voice();

    @Override
    public String toString() {
        return type;
    }
}
