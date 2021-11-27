package lesson7;

public class Cat {

    private String name;
    private String color;
    private int age;
    private double weight;
    private boolean isHomeless;

    public Cat(String name, String color, int age, double weight, boolean isHomeless) {
        this.name = checkNotNull(name);
        this.color = checkNotNull(color);
        this.age = age;
        this.weight = weight;
        this.isHomeless = isHomeless;
    }

    public Cat(String color, int age, double weight, boolean isHomeless) {
        this.name = "не определено";
        this.color = checkNotNull(color);
        this.weight = weight;
        this.age = age;
        this.isHomeless = isHomeless;
    }

    public void run(int n) {
        if (n <= 0) {
            System.out.println(nameOrColor() + " попятился");
        }else if (n <= 200) {
            System.out.println(nameOrColor() + " пробежал " + n + " метров");
        } else {
            System.out.println(nameOrColor() + " пробежал 200 метров и больше не захотел");
        }
    }

    public void swim(int n) {
        if (n <= 0) {
            System.out.println(nameOrColor() + " отбежал от воды");
        } else {
            System.out.println(nameOrColor() + " полез в воду, но быстро передумал");
        }
    }

    public String nameOrColor() {
        return !name.equals("не определено") ? "кот " + name : color + " кот";
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public boolean isHomeless() {
        return isHomeless;
    }

    public void setHomeless(boolean homeless) {
        isHomeless = homeless;
    }
}
