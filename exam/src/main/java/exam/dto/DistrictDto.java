package exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDto {

    private Long id;

    private String name;

    private List<StreetDto> streets;
}
