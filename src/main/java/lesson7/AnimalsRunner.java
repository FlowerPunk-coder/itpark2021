package lesson7;

public class AnimalsRunner {

    public static void main(String[] args) {

        Dog dog = new Dog("рыжий", 3, 4.5, true);
        Dog anotherDog = new Dog("Рекс", "черный", 2, 3, false);
        dog.run(1000);
        anotherDog.swim(0);

        Cat cat = new Cat("черно-белый", 1, 2, true);
        Cat anotherCat = new Cat("Барсик","черепаховый", 1, 2, false);
        cat.run(250);
        anotherCat.swim(15);

        Tiger tiger = new Tiger(5, 15, false);
        Tiger anotherTiger = new Tiger("Тромбон",5, 15, true);
        tiger.run(500);
        anotherTiger.swim(32);

    }


}
