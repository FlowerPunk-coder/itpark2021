package exam.mapper;

import exam.dto.StreetDto;
import exam.model.Street;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {DistrictMapper.class, HouseMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StreetMapper {

    StreetDto toStreetDto(Street street);


    Street toStreetEntity(StreetDto streetDto);

    default List<StreetDto> toStreetDtos(List<Street> streets) {
        return streets.stream().map(this::toStreetDto).collect(Collectors.toList());
    }
}
