package lesson14.optionalHomeWork;

import lesson14.Caller;

import java.util.HashSet;
import java.util.Set;

public class HashTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Set<Caller> callers = new HashSet<>();
         for (int i = 0; i < 10000; i++) {
             callers.add(new Caller());
         }
        Caller tempCaller = new Caller();
        System.out.println(callers.contains(tempCaller));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " mc, занял поиск с уникальными значениями хешкода");

        start = System.currentTimeMillis();
        Set<TestCaller> testCallerSet = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            testCallerSet.add(new TestCaller());
        }
        TestCaller testCaller = new TestCaller();
        System.out.println(testCallerSet.contains(testCaller));
        end = System.currentTimeMillis();
        System.out.println(end - start + " mc, занял поиск с одинаковыми значениями хешкода");

    }


}
