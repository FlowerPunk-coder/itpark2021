package lesson14;

import java.util.*;

public record ListOfCallers(double PART) {

    public void getPartOfCallersList(Caller caller, List<Caller> callers) {
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

    public void setCallerSet(Caller caller, Set<Caller> callers) {
        int count = 0;
        Caller tempCaller;
        Set<Caller> callerSet = new HashSet<>();
        Iterator<Caller> iterator = callers.iterator();
        while (count < callers.size() * PART) {
            if (iterator.hasNext()) {
                tempCaller = iterator.next();
                if (!caller.equals(tempCaller) && !callerSet.contains(tempCaller)) {
                    if (new Random().nextInt(10) > 5) {
                        callerSet.add(tempCaller);
                        count++;
                    }
                }
            }
        }
        caller.setCallerSet(callerSet);
    }

    public void setCallerMap(Caller caller, Map<Integer, Caller> callers) {
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
