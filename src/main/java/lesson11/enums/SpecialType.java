package lesson11.enums;

public enum SpecialType {

    POLICE("Полиция"), AMBULANCE("Скорая"), FIRE("Пожарная");

    private String type;

    SpecialType(String type) {
        this.type = type;
    }

    public String getSpecialType() {
        return type;
    }
}
