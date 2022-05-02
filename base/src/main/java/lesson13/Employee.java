package lesson13;

import java.util.Objects;

public class Employee {

    private int idNumber;
    private final String FIO;
    private int workAge;

    public Employee(int tNumber, String FIO, int workAge) {
        this.idNumber = tNumber;
        this.FIO = FIO;
        this.workAge = workAge;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getFIO() {
        return FIO;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Табельный номер = " + idNumber +
                ", ФИО = '" + FIO + '\'' +
                ", Стаж = " + workAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return workAge == employee.workAge && FIO.equalsIgnoreCase(employee.FIO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, workAge);
    }
}
