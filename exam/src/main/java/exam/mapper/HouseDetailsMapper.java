package exam.mapper;


import exam.dto.HouseDetailsDto;
import exam.model.HouseDetails;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {HouseMapper.class, EntranceMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HouseDetailsMapper {

    HouseDetailsDto toHouseDetailsDto(HouseDetails houseDetails);
    HouseDetails toHouseDetailsEntity(HouseDetailsDto houseDetailsDto);

    default List<HouseDetailsDto> toHouseDetailsDtos(List<HouseDetails> housesDetails) {
        return housesDetails.stream().map(this::toHouseDetailsDto).collect(Collectors.toList());
    }
}
