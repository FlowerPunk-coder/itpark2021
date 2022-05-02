package lesson13;

import lesson13.creator.EmployeeFactory;

import java.util.List;
import java.util.Set;

public class EmployeeRunner {

    public static void main(String[] args) {
        EmployeeFactory constructor = new EmployeeFactory();
        Set<Employee> empSet = constructor.createSetEmployees(100);
        List<Employee> empList = constructor.createListEmployees(100);
        EmployeeUtils.printEmployee(empSet, 15);
        EmployeeUtils.printEmployee(empList, 8);
        System.out.println(empList.size());
        EmployeeUtils.deleteOddFromEnd(empList);
        System.out.println(empList.size());
    }
}
