package lesson14;

import lesson13.creator.FemaleFullNameUtils;
import lesson13.creator.MaleFullNameUtils;
import lesson14.factory.AddressBook;
import lesson14.factory.PhoneNumberUtil;

import java.util.List;
import java.util.Random;

public class Caller {

    private final String FIO;
    private String phoneNumber;
    private List<Caller> callerList;

    public Caller() {
        this.FIO = new Random().nextBoolean() ? MaleFullNameUtils.getFio() : FemaleFullNameUtils.getFio();
        this.phoneNumber = PhoneNumberUtil.getPhoneNumber();
    }

    public Caller(String FIO, String phoneNumber) {
        this.FIO = FIO;
        this.phoneNumber = phoneNumber;
    }

    public void setCallerList(List<Caller> callerList) {
        this.callerList = callerList;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return FIO + " " + phoneNumber;
    }
}
