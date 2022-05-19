package exam.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireBoxDto {

    private long id;

    private boolean isComplete;

    private boolean hasDoubleRoll;

    private boolean hasFireHose;

    private boolean isAccess;

    private boolean hasComponent;

    private EntranceDto entrance;
}
