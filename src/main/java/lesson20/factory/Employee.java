package lesson20.factory;


import lombok.Data;

@Data
public class Employee {

    private int id;
    private String fio;
    private String login;
    private Department department;
    private Job job;

    public Employee() {

    }

    public Employee(int id, String fio, Department department, Job job) {
        this.id = id;
        this.fio = fio;
        this.department = department;
        this.job = job;
    }



}
