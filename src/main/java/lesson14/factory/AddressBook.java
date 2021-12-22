package lesson14.factory;

import lesson14.Caller;

import java.util.*;

public class AddressBook {


    public static Set<Caller> addressBookAtSet(int n) {
        Set<Caller> callerSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Caller tempCaller = new Caller();
            if (!callerSet.contains(tempCaller)) {
                callerSet.add(tempCaller);
            } else {
                i--;
            }
        }
        return callerSet;
    }

    public static List<Caller> addressBookAtList(int n) {
        List<Caller> callerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Caller tempCaller = new Caller();
            if (!callerList.contains(tempCaller)) {
                callerList.add(tempCaller);
            } else {
                i--;
            }
        }
        return callerList;
    }

    public static Map<String, String> addressBookAtMap(int n) {
        Map <String, String> callerMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Caller tempCaller = new Caller();
            if (!callerMap.containsKey(tempCaller.getPhoneNumber())) {
                callerMap.put(tempCaller.getPhoneNumber(), tempCaller.getFIO());
            } else {
                i--;
            }
        }
        return callerMap;
    }




}
