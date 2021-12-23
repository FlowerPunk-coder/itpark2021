package lesson14.factory;

import lesson14.Caller;
import lesson14.factory.AddressBook;

import java.util.ArrayList;
import java.util.List;

public class AddressBookAtList implements AddressBook {

    private List<Caller> callerList;

    public void addressBook(int n) {
        this.callerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Caller tempCaller = new Caller();
            if (!this.callerList.contains(tempCaller)) {
                this.callerList.add(tempCaller);
            } else {
                i--;
            }
        }
    }

    public List<Caller> getCallerList() {
        return this.callerList;
    }
}
