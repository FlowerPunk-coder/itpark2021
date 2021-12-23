package lesson14;

import lesson14.factory.AddressBookAtList;
import lesson14.factory.AddressBookAtMap;
import lesson14.factory.AddressBookAtSet;

import java.util.*;

public class CallerRunner {

    public static void main(String[] args) {
        Date startDate = new Date();
        AddressBookAtList atList = new AddressBookAtList();
        atList.addressBook(3000);
        for (int i = 0; i < atList.getCallerList().size(); i++) {
            Caller caller = atList.getCallerList().get(i);
            caller.getPartOfCallersList(atList.getCallerList());
        }
        //Ищем самые часто встречающиеся контакты
        Map<Caller, Integer> resultMap = new HashMap<>();
        int max = 1;
        for (int i = 0; i < atList.getCallerList().size(); i++) {
            int count = 0;
            for (int j = 0; j < atList.getCallerList().size(); j++) {
                if (atList.getCallerList().get(j).getCallerList().contains(atList.getCallerList().get(i))) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                resultMap.put(atList.getCallerList().get(i), max);
            }
        }
        int maxValue = Collections.max(resultMap.values());
        for (Map.Entry<Caller, Integer> caller : resultMap.entrySet()) {
            if (caller.getValue() == maxValue) {
                System.out.println("Самый часто встречающийся контакт: " + caller.getKey() + ", встречается "
                        + caller.getValue() + " раз.");
            }
        }
        Date finishList = new Date();
        System.out.println("----------------------------------");
        System.out.println(finishList.getTime() - startDate.getTime() + " мс, работала коллекция List");
        System.out.println("----------------------------------");



        Date startSet = new Date();
        AddressBookAtSet atSet = new AddressBookAtSet();
        atSet.addressBook(10);
        for (Caller caller : atSet.getCallerSet()) {
            caller.setCallerSet(atSet.getCallerSet());
        }

        Date endSet = new Date();
        System.out.println("----------------------------------");
        System.out.println(endSet.getTime() - startSet.getTime() + " мс, работала коллекция SET");
        System.out.println("----------------------------------");

        Date startMap = new Date();
        AddressBookAtMap atMap = new AddressBookAtMap();
        atMap.addressBook(10);

        for (Map.Entry<Integer, Caller> entry : atMap.getCallerMap().entrySet()) {
            entry.getValue().setCallerMap(atMap.getCallerMap());
        }

        Date endMap = new Date();
        System.out.println("----------------------------------");
        System.out.println(endMap.getTime() - startMap.getTime() + " мс, работала МАР");
        System.out.println("----------------------------------");

    }
}
