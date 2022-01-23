package lesson20.factory;

import lesson20.factory.enums.NameOfDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {

    private NameOfDepartment nameOfDepartment;
    private String city;
}
