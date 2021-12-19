package lesson13.creator;

import java.util.Random;

public class FemaleFullName {

    private static String[] firstNameArr = {"Петрова" , "Иванова", "Рыжова", "Сергеева", "Ульянова", "Санько", "Петровская", "Босинзон"};
    private static String[] lastNameArr = {"Вера", "Юлия", "Любовь", "Марина", "Оксана", "Надежда", "Анна", "Сара"};
    private static String[] fatherNameArr = {"Алексеевна", "Андреевна", "Максимовна", "Владимировна", "Петровна", "Сергеевна"};


    public String getFio() {
        return getFirstName() + " " + getLastName() + " " + getFatherName();
    }

    public String getFirstName() {
        return firstNameArr[new Random().nextInt(fatherNameArr.length)];
    }

    public String getLastName() {
        return lastNameArr[new Random().nextInt(lastNameArr.length)];
    }

    public String getFatherName(){
        return fatherNameArr[new Random().nextInt(fatherNameArr.length)];
    }
}
