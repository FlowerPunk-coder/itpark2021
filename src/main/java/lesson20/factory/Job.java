package lesson20.factory;

import lesson20.factory.enums.NameOfPost;
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
