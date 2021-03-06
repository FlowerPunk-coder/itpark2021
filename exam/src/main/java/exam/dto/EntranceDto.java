package exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntranceDto {

    private long id;

    private int numberEntrance;

    private int numberOfLevels;

    private int numberOfPipes;

    private int numberOfFireBoxes;

    private int numberOfFireCranes;

    private boolean hasFirstLevel;

    private boolean work;

    private boolean basement;

    private boolean attic;

    private HouseDetailsDto houseDetails;

}
