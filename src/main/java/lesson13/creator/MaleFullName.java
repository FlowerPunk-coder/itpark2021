package lesson13.creator;

import java.util.Random;

public class MaleFullName {

    private static String[] firstNameArr = {"Петров" , "Иванов", "Рыжов", "Сергеев", "Ульянов", "Санько", "Петровский", "Босинзон"};
    private static String[] lastNameArr = {"Андрей", "Максим", "Иван", "Владимир", "Евгений", "Сергей", "Виталий", "Изя"};
    private static String[] fatherNameArr = {"Алексеевич", "Андреевич", "Максимович", "Владимирович", "Петрович", "Сергеевич"};


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
