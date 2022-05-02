package lesson14;

import lesson14.factory.AddressBookAtList;
import lesson14.factory.AddressBookAtMap;
import lesson14.factory.AddressBookAtSet;

import java.util.*;

public class CallerRunner {

    public static void main(String[] args) {

        long startList = System.currentTimeMillis();
        AddressBookAtList atList = new AddressBookAtList();
        atList.addressBook(100);
        for (int i = 0; i < atList.getCallerList().size(); i++) {
            ListOfCallersUtils.setCallersList(atList.getCallerList().get(i), atList.getCallerList());
        }
        //Ищем самые часто встречающиеся контакты
        printResult(FrequencyContactUtil.frequencyContact(atList.getCallerList()));

        long finishList = System.currentTimeMillis();
        System.out.println("----------------------------------");
        System.out.println(((finishList - startList) / 1000) + " с, работала коллекция List");
        System.out.println("----------------------------------");

        long startSet = System.currentTimeMillis();
        AddressBookAtSet atSet = new AddressBookAtSet();
        atSet.addressBook(100);
        for (Caller caller : atSet.getCallerSet()) {
            ListOfCallersUtils.setCallersSet(caller, atSet.getCallerSet());
        }
        printResult(FrequencyContactUtil.frequencyContact(atSet.getCallerSet()));

        long endSet = System.currentTimeMillis();
        System.out.println("----------------------------------");
        System.out.println(((endSet - startSet) / 1000) + " с, работала коллекция SET");
        System.out.println("----------------------------------");

        long startMap = System.currentTimeMillis();
        AddressBookAtMap atMap = new AddressBookAtMap();
        atMap.addressBook(100);
        for (Map.Entry<Integer, Caller> entry : atMap.getCallerMap().entrySet()) {
           ListOfCallersUtils.setCallersMap(entry.getValue(), atMap.getCallerMap());
        }
        printResult(FrequencyContactUtil.frequencyContact(atMap.getCallerMap()));

        long endMap = System.currentTimeMillis();
        System.out.println("----------------------------------");
        System.out.println(((endMap - startMap) / 1000) + " мс, работала МАР");
        System.out.println("----------------------------------");

    }

    public static void printResult(Map<Caller, Integer> map) {
        int maxValue = Collections.max(map.values());
        for (Map.Entry<Caller, Integer> caller : map.entrySet()) {
            if (caller.getValue() == maxValue) {
                System.out.println("Самый часто встречающийся контакт: " + caller.getKey() + ", встречается "
                        + caller.getValue() + " раз.");
            }
        }
    }
}
