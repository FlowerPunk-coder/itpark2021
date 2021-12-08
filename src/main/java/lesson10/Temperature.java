package lesson10;

public enum Temperature {

    KELVIN("К"), CELSIUS("\u00b0C"), FAHRENHEIT("\u00b0F");

    private String type;

    Temperature (String type) {
        this.type = type;
    }

    public String getType () {
        return type;
    }


}
