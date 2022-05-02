package lesson14.optionalHomeWork;

import lesson13.creator.FemaleFullNameUtils;
import lesson13.creator.MaleFullNameUtils;
import lesson14.factory.PhoneNumberUtil;

import java.util.*;

public class TestCaller {

    private final String fio;
    private String phoneNumber;
    private List<TestCaller> callerList;
    private Set<TestCaller> callerSet;
    private Map<Integer, TestCaller> callerMap;

    public TestCaller() {
        this.fio = new Random().nextBoolean() ? MaleFullNameUtils.getFio() : FemaleFullNameUtils.getFio();
        this.phoneNumber = PhoneNumberUtil.getPhoneNumber();
    }

    public List<TestCaller> getCallerList() {
        return callerList;
    }

    public Set<TestCaller> getCallerSet() {return callerSet;}

    public Map<Integer, TestCaller> getCallerMap() {return callerMap;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCaller testCaller = (TestCaller) o;
        return Objects.equals(phoneNumber, testCaller.phoneNumber);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public String getFio() {
        return fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return fio + " " + phoneNumber;
    }

    public void setCallerList(List<TestCaller> callerList) {
        this.callerList = callerList;
    }

    public void setCallerSet(Set<TestCaller> callerSet) {
        this.callerSet = callerSet;
    }

    public void setCallerMap(Map<Integer, TestCaller> callerMap) {
        this.callerMap = callerMap;
    }
}
