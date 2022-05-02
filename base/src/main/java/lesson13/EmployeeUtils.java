package lesson13;

import java.util.*;

public class EmployeeUtils {

    public static void printEmployee(Collection<Employee> employees, int workAge) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee printEmployee = iterator.next();
            if (printEmployee.getWorkAge() == workAge) {
                System.out.println(printEmployee);
            }
        }
    }

    public static void deleteOddFromEnd(List<Employee> employees) {
        ListIterator<Employee> iterator = employees.listIterator(employees.size());
        while (iterator.hasPrevious()) {
            int checkIndex = iterator.previousIndex();
            iterator.previous();
            if (checkIndex % 2 != 0) {
                iterator.remove();
            }
        }
    }
}
