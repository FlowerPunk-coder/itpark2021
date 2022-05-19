package exam.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {

    private long id;

    private int number;

    private String sing;

    private Integer prefix;

    private boolean checked;

    private Timestamp date;

    private StreetDto street;
}
