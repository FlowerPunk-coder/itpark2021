package lesson20.factory;

import lesson20.factory.enums.NameOfDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private NameOfDepartment nameOfDepartment;
    private String city;
}
