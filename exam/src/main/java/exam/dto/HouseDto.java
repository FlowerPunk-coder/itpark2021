package exam.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {

    private long id;

    private int number;

    private String sing;

    private int prefix;

    private boolean hasChecked;

}
