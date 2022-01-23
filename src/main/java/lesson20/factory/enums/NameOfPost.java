package lesson20.factory.enums;

public enum NameOfPost {

    ENGINEER("Инженер"),
    SELLER("Продавец"),
    ADMINISTRATOR("Администратор"),
    SERVICEMAN("Разнорабочий");

    private String post;

    NameOfPost(String post) {
        this.post = post;
    }
}
