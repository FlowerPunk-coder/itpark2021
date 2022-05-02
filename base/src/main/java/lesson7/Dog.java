package lesson7;

public class Dog {

    private String name;
    private String color;
    private int age;
    private double weight;
    private boolean isHomeless;


    public Dog(String name, String color, int age, double weight, boolean isHomeless) {
        this.name = checkNotNull(name);
        this.color = checkNotNull(color);
        this.age = age;
        this.weight = weight;
        this.isHomeless = isHomeless;
    }

    public Dog(String color, int age, double weight, boolean isHomeless) {
        this.name = "не определено";
        this.color = checkNotNull(color);
        this.age = age;
        this.weight = weight;
        this.isHomeless = isHomeless;
    }

    public void run(int n) {
        if (n <= 0) {
            System.out.println(nameOrColor() + " попятился");
        }else if (n <= 500) {
            System.out.println(nameOrColor() + " пробежал " + n + " метров");
        } else {
            System.out.println(nameOrColor() + " пробежал 500 метров и упал...");
        }
    }

    public void swim(int n) {
        if (n <= 0) {
            System.out.println(nameOrColor() + " отбежал от воды");
        } else if (n <= 10) {
            System.out.println(nameOrColor() + " проплыл " + n + " метров");
        } else {
            System.out.println(nameOrColor() + " проплыл 10 метров и поплыл назад");
        }
    }

    public String nameOrColor() {
        return  !name.equals("не определено") ? "пес " + name : color + " пес";
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHomeless() {
        return isHomeless;
    }

    public void setHomeless(boolean homeless) {
        isHomeless = homeless;
    }
}
