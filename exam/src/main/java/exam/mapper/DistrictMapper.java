package exam.mapper;

import exam.dto.DistrictDto;
import exam.model.District;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = StreetMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DistrictMapper {

    DistrictDto toDistrictDto(District district);

    District toDistrictEntity(DistrictDto district);

    default List<DistrictDto> toDistrictDtos(List<District> districts) {
        return districts.stream().map(this::toDistrictDto).collect(Collectors.toList());
    }
}
