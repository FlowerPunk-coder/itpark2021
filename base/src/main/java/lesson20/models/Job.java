package lesson20.models;

import lesson20.models.enums.NameOfPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Job {

    private NameOfPost post;
    private int salary;

}
