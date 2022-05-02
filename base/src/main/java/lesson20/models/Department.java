package lesson20.models;

import lesson20.models.enums.NameOfDepartment;
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
