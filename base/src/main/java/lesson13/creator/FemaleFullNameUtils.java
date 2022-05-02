package lesson13.creator;

import java.util.Random;

public class FemaleFullNameUtils {

    private static String[] firstNameArr = {"Петрова" , "Иванова", "Рыжова", "Сергеева", "Ульянова", "Санько", "Петровская", "Босинзон"};
    private static String[] lastNameArr = {"Вера", "Юлия", "Любовь", "Марина", "Оксана", "Надежда", "Анна", "Сара"};
    private static String[] fatherNameArr = {"Алексеевна", "Андреевна", "Максимовна", "Владимировна", "Петровна", "Сергеевна"};


    public static String getFio() {
        return getFirstName() + " " + getLastName() + " " + getFatherName();
    }

    public static String getFirstName() {
        return firstNameArr[new Random().nextInt(fatherNameArr.length)];
    }

    public static String getLastName() {
        return lastNameArr[new Random().nextInt(lastNameArr.length)];
    }

    public static String getFatherName(){
        return fatherNameArr[new Random().nextInt(fatherNameArr.length)];
    }
}
