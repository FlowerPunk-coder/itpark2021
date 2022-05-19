package exam.dto;

import exam.model.Entrance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDetailsDto {

    private long id;

    private int numberOfSystems;

    private int numberOfEntrances;

    private int numberOfLevels;

    private boolean multilevel;

    private String comment;

    private HouseDto house;

    private List<Entrance> entrances;
}
