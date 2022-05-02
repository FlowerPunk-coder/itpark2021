package lesson14.factory;

import lesson14.Caller;

import java.util.HashMap;
import java.util.Map;

public class AddressBookAtMap implements AddressBook {

    private Map<Integer, Caller> callerMap = new HashMap<>();

    public void addressBook(int n) {
        int id = 1;
        for (int i = 0; i < n; i++) {
            Caller tempCaller = new Caller();
            if (!this.callerMap.containsValue(tempCaller)) {
                this.callerMap.put(id++, tempCaller);
            } else {
                i--;
            }
        }
    }

    public Map<Integer, Caller> getCallerMap() {
        return this.callerMap;
    }
}
