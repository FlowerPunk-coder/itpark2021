package lesson13.creator;

import lesson13.Employee;


import java.util.*;

public class EmployeeFactory {

    private final static int MIN_WORK_AGE = 1;
    private static int countID = 1;


    public Employee createEmployee() {
        String fio = new Random().nextBoolean() ? MaleFullNameUtils.getFio() : FemaleFullNameUtils.getFio();
        return new Employee(countID++, fio, new Random().nextInt(50) + MIN_WORK_AGE);
    }

    public Set<Employee> createSetEmployees(int n) {
        Set<Employee> employeeSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            employeeSet.add(createEmployee());
        }
        return employeeSet;
    }

    public List<Employee> createListEmployees(int n) {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            employeeList.add(createEmployee());
        }
        return employeeList;
    }
}
