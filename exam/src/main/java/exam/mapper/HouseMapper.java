package exam.mapper;

import exam.dto.HouseDto;
import exam.model.House;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = StreetMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HouseMapper {

    HouseDto toHouseDto(House house);

    House toHouseEntity(HouseDto house);

    default List<HouseDto> toHouseDtos(List<House> houses) {
        return houses.stream().map(this::toHouseDto).collect(Collectors.toList());
    }
}
