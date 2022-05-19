package exam.mapper;

import exam.dto.FireBoxDto;
import exam.model.FireBox;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = EntranceMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FireBoxMapper {

    FireBoxDto toFireBoxDto(FireBox fireBox);
    FireBox toFireBoxEntity(FireBoxDto fireBox);

    default List<FireBoxDto> toFireBoxDtos(List<FireBox> fireBoxes) {
        return fireBoxes.stream().map(this::toFireBoxDto).collect(Collectors.toList());
    }
}
