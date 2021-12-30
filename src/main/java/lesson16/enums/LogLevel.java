package lesson16.enums;

public enum LogLevel {

    ERROR("Ошибка"),
    WARN("Предупреждение"),
    INFO("Информация"),
    DEBUG("Обработка"),
    TRACE("Трасировка");

    private String name;

    LogLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
