package lesson14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyContactUtil {

    private static Map<Caller, Integer> resultMap = new HashMap<>();


    public static Map<Caller, Integer> frequencyContact(List<Caller> atList) {
        resultMap.clear();
        for (int i = 0; i < atList.size(); i++) {
            int count = 0;
            for (Caller caller : atList) {
                if (caller.getCallerList().contains(atList.get(i))) {
                    count++;
                }
            }
            resultMap.put(atList.get(i), count);
        }
        return resultMap;
    }

    public static Map<Caller, Integer> frequencyContact(Set<Caller> callerSet) {
        resultMap.clear();
        for (Caller searchCaller : callerSet) {
            int count = 0;
            for (Caller caller : searchCaller.getCallerSet()) {
                if (caller.getCallerSet().contains(searchCaller)) {
                    count++;
                }
            }
            resultMap.put(searchCaller, count);
        }
        return resultMap;
    }

    public static Map<Caller, Integer> frequencyContact(Map<Integer, Caller> callerMap) {
        resultMap.clear();
        for (Caller searchCaller : callerMap.values()) {
            int count = 0;
            for (Caller caller : searchCaller.getCallerMap().values()) {
                if (caller != null && caller.getCallerMap().containsValue(searchCaller)) {
                    count++;
                }
            }
            resultMap.put(searchCaller, count);
        }
        return resultMap;
    }

    public static Map<Caller, Integer> getResultMap() {
        return resultMap;
    }
}
