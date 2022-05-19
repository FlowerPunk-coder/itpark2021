package exam.mapper;

import exam.dto.EntranceDto;
import exam.model.Entrance;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {HouseDetailsMapper.class, FireBoxMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EntranceMapper {

    EntranceDto toEntranceDto(Entrance entrance);
    Entrance toEntranceEntity(EntranceDto entrance);

    default List<EntranceDto> toEntranceDtos(List<Entrance> entrances) {
        return entrances.stream().map(this::toEntranceDto).collect(Collectors.toList());
    }
}
