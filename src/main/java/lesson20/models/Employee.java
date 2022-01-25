package lesson20.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Employee {

    private int id;
    private String fio;
    private String login;
    private Department department;
    private Job job;

    public Employee(int id, String fio, Department department, Job job) {
        this.id = id;
        this.fio = fio;
        this.department = department;
        this.job = job;
    }



}
