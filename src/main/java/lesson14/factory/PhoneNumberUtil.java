package lesson14.factory;

import lesson14.enums.MobileOperators;

import java.util.*;

public class PhoneNumberUtil {

    private static Set<String> phoneNumbers = new HashSet<>();

    public static String getPhoneNumber(){
        String phoneNumber;
        while (true) {
            StringBuilder temp = new StringBuilder();
            temp.append(getOperator());
            for (int i = 0; i < 7; i++) {
                temp.append(getNumber());
            }
            phoneNumber = temp.toString();
            if (!phoneNumbers.contains(phoneNumber)) {
                phoneNumbers.add(phoneNumber);
                break;
            }
        }
        return phoneNumber;
    }

    private static int getOperator() {
        int code = 0;
        int choice = new Random().nextInt(4);
        switch (choice) {
            case 0 -> code = MobileOperators.BEELINE.getBEELINE_CODE();
            case 1 -> code = MobileOperators.MTC.getMTC_CODE();
            case 2 -> code = MobileOperators.MEGAFON.getMEGAFON_CODE();
            case 3 -> code = MobileOperators.TELE2.getTELE2_CODE();
        }
        return code;
    }

    private static int getNumber() {
        return new Random().nextInt(10);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
