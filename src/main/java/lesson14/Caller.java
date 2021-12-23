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

    public void getPartOfCallersList(List<Caller> callers) {
        callerList = new ArrayList<>();
        Caller caller;
        for (int i = 0; i < callers.size() * PART;) {
            caller = callers.get(new Random().nextInt(callers.size()));
            if (!caller.equals(this) & !callerList.contains(caller)) {
                callerList.add(caller);
                i++;
            }
        }
    }

    public void setCallerSet(Set<Caller> callerSet) {
        int count = 0;
        Caller tempCaller;
        this.callerSet = new HashSet<>();
        Iterator<Caller> iterator = callerSet.iterator();
        while (count < callerSet.size() * PART) {
            if (iterator.hasNext()) {
                tempCaller = iterator.next();
                if (!this.equals(tempCaller) && !this.callerSet.contains(tempCaller)) {
                    if (new Random().nextInt(10) > 5) {
                        this.callerSet.add(tempCaller);
                        count++;
                    }
                }
            }
        }
    }

    public void setCallerMap(Map<Integer, Caller> callerMap) {
        int count = 0;
        int id = 1;
        Caller tempCaller;
        this.callerMap = new HashMap<>();
        while (count < callerMap.size() * PART) {
            tempCaller = callerMap.get(new Random().nextInt(callerMap.size()));
            if (!this.equals(tempCaller) && !this.callerMap.containsValue(tempCaller)) {
                this.callerMap.put(id++, tempCaller);
                count++;
            }
        }
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

}
