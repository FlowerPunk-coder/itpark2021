package lesson11;

import lesson11.enums.SpecialType;
import lesson11.inter.Intercepting;


public class SpecialCar extends Automobile implements Intercepting {

    SpecialType type;

    SpecialCar(SpecialType type) {
        super();
        this.type = type;
    }

    @Override
    public void detention(Automobile auto) {
        System.out.println(type.getSpecialType() + " задержала автомобиль нарушителя: " + auto.toString());
    }

    @Override
    public int acceleration() {
        return 0;
    }
}
