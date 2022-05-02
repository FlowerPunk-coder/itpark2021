package lesson14.enums;

import java.util.Random;

public enum MobileOperators {

    BEELINE ("Билайн"), MTC("МТС"), MEGAFON("МегаФон"), TELE2("Теле2");

    private final String name;
    private final int[] BEELINE_CODE = {903, 905, 909};
    private final int[] MTC_CODE = {916, 917, 918};
    private final int[] MEGAFON_CODE = {926, 925, 924};
    private final int[] TELE2_CODE = {997, 998, 999};

    MobileOperators(String name) {
        this.name = name;
    }

    public int getBEELINE_CODE() {
        return BEELINE_CODE[new Random().nextInt(BEELINE_CODE.length)];
    }

    public int getMTC_CODE() {
        return MTC_CODE[new Random().nextInt(MTC_CODE.length)];
    }

    public int getMEGAFON_CODE() {
        return MEGAFON_CODE[new Random().nextInt(MEGAFON_CODE.length)];
    }

    public int getTELE2_CODE() {
        return TELE2_CODE[new Random().nextInt(TELE2_CODE.length)];
    }

    public String toString(){
        return name;
    }
}
