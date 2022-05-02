package lesson14;

import java.util.*;

public class ListOfCallersUtils {

    private final static double PART = 0.1;

    public static void setCallersList(Caller caller, List<Caller> callers) {
        List<Caller> callerList = new ArrayList<>();
        for (int i = 0; i < callers.size() * PART; ) {
            Caller tempCaller = callers.get(new Random().nextInt(callers.size()));
            if (!caller.equals(tempCaller) & !callerList.contains(tempCaller)) {
                callerList.add(tempCaller);
                i++;
            }
        }
        caller.setCallerList(callerList);
    }

    public static void setCallersSet(Caller caller, Set<Caller> callers) {
        int count = 0;
        Caller tempCaller;
        Set<Caller> callerSet = new HashSet<>();
        Iterator<Caller> iterator = callers.iterator();
        while (count < callers.size() * PART) {
            if (iterator.hasNext()) {
                tempCaller = iterator.next();
                if (!caller.equals(tempCaller) && !callerSet.contains(tempCaller)) {
                    if (new Random().nextBoolean()) {
                        callerSet.add(tempCaller);
                        count++;
                    }
                }
            } else {
                count++;
            }
        }
        caller.setCallerSet(callerSet);
    }

    public static void setCallersMap(Caller caller, Map<Integer, Caller> callers) {
        int count = 0;
        int id = 1;
        Caller tempCaller;
        Map<Integer, Caller> callerMap = new HashMap<>();
        while (count < callers.size() * PART) {
            tempCaller = callers.get(new Random().nextInt(callers.size()));
            if (!caller.equals(tempCaller) && !callerMap.containsValue(tempCaller)) {
                callerMap.put(id++, tempCaller);
                count++;
            }
        }
        caller.setCallerMap(callerMap);
    }
}
