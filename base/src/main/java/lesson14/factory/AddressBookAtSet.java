package lesson14.factory;

import lesson14.Caller;

import java.util.HashSet;
import java.util.Set;

public class AddressBookAtSet implements AddressBook {

    private Set<Caller> callerSet = new HashSet<>();

    public void addressBook(int n) {
        for (int i = 0; i < n; i++) {
            Caller tempCaller = new Caller();
            if (!this.callerSet.contains(tempCaller)) {
                this.callerSet.add(tempCaller);
            } else {
                i--;
            }
        }
    }

    public Set<Caller> getCallerSet() {
        return this.callerSet;
    }

}
