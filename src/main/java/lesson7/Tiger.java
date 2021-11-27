package lesson7;

public class Tiger {

    private String name;
    private int age;
    private double weight;
    private boolean isCounted;

    public Tiger(String name, int age, double weight, boolean isCounted) {
        this.name = checkNotNull(name);
        this.age = age;
        this.weight = weight;
        this.isCounted = isCounted;
    }

    public Tiger(int age, double weight, boolean isCounted) {
        this.name = "не определено";
        this.age = age;
        this.weight = weight;
        this.isCounted = isCounted;
    }

    public void run(int n) {
        if (n <= 0) {
            System.out.println(nameOrColor() + " попятился");
        } else if (n <= 400) {
            System.out.println(nameOrColor() + " пробежал " + n + " метров, но очень быстро");
        } else {
            System.out.println(nameOrColor() + " пробежал 400 метров, потом хотел еще... А зачем?");
        }
    }

    public void swim(int n) {
        if (n <= 0) {
            System.out.println(nameOrColor() + " отбежал от воды");
        } else {
            System.out.println(nameOrColor() + " полез в воду, попил и отошел");
        }
    }

    public String nameOrColor() {
        return !name.equals("не определено") ? "тигр " + name : "тигр";
    }

    public String checkNotNull(String a) {
        if (a == null) {
            a = "не определено";
        }
        return a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isCounted() {
        return isCounted;
    }

    public void setCounted(boolean counted) {
        isCounted = counted;
    }
}
