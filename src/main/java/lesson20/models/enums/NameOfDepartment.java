package lesson20.models.enums;

public enum NameOfDepartment {

    TECHNICAL("Технический отдел"),
    SALE("Отдел продаж"),
    ADMINISTRATORS("Администраторы"),
    SERVICE("Отдел обслуживания");

    private String name;


    NameOfDepartment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
