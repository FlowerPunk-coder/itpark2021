package lesson20.factory;

import lesson13.creator.FemaleFullNameUtils;
import lesson13.creator.MaleFullNameUtils;
import lesson20.models.Department;
import lesson20.models.Employee;
import lesson20.models.Job;
import lesson20.models.enums.NameOfDepartment;
import lesson20.models.enums.NameOfPost;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmployeeFactory {

    private static int id = 1;
    @Setter
    private static List<String> cities = Arrays.asList("Москва", "Санкт-Петербург", "Самара", "Уфа");
    private static final int MIN_SALARY = 50_000;

    public static Employee getRandomEmployee() {
        return new Employee(id++, getFIO(), getDepart(), getJob());
    }

    public static List<Employee> getListOfRandomEmployees(int n) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Employee emp = EmployeeFactory.getRandomEmployee();
            emp.setLogin(createLogin(emp.getFio(), emp.getId()));
            employees.add(emp);
        }
        return employees;
    }

    public static String getFIO() {
        return new Random().nextBoolean() ? MaleFullNameUtils.getFio() :
                FemaleFullNameUtils.getFio();
    }

    public static String getCity() {
        return cities.get(new Random().nextInt(cities.size()));
    }

    public static Department getDepart(){
        NameOfDepartment[] values = NameOfDepartment.values();
        return new Department(values[new Random().nextInt(values.length)], getCity());
    }

    public static Job getJob() {
        NameOfPost[] values = NameOfPost.values();
        NameOfPost post = values[new Random().nextInt(values.length)];
        int salary;
        switch (post.ordinal()) {
            case 0 -> salary = 150_000;
            case 1 -> salary = 100_000;
            case 2 -> salary = 70_000;
            case 3 -> salary = 60_000;
            default -> salary = MIN_SALARY;
        }
        return new Job(post, salary);
    }

    private static String createLogin(String fio, int id) {
        String[] first = fio.split(" ");
        return first[0] + "_" + id;
    }
}
