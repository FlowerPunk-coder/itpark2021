package lesson14;

import lesson13.creator.FemaleFullNameUtils;
import lesson13.creator.MaleFullNameUtils;
import lesson14.factory.PhoneNumberUtil;

import java.util.*;

public class Caller {

    private final String FIO;
    private String phoneNumber;
    private List<Caller> callerList;
    private Set<Caller> callerSet;
    private Map<Integer, Caller> callerMap;
    private final double PART = 0.1;

    public Caller() {
        this.FIO = new Random().nextBoolean() ? MaleFullNameUtils.getFio() : FemaleFullNameUtils.getFio();
        this.phoneNumber = PhoneNumberUtil.getPhoneNumber();
    }



    public List<Caller> getCallerList() {
        return callerList;
    }

    public Set<Caller> getCallerSet() {return callerSet;}

    public Map<Integer, Caller> getCallerMap() {return callerMap;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caller caller = (Caller) o;
        return Objects.equals(phoneNumber, caller.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    public String getFIO() {
        return FIO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return FIO + " " + phoneNumber;
    }

    public void setCallerList(List<Caller> callerList) {
        this.callerList = callerList;
    }

    public void setCallerSet(Set<Caller> callerSet) {
        this.callerSet = callerSet;
    }

    public void setCallerMap(Map<Integer, Caller> callerMap) {
        this.callerMap = callerMap;
    }
}
