package exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDetailsDto {

    private long id;

    private Timestamp date;

    private int numberOfSystems;

    private int numberOfEntrances;

    private int numberOfLevels;

    private boolean multilevel;

    private String comment;
}
