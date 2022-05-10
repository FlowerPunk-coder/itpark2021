package lesson43.mapper;

import lesson43.dto.CountryDto;
import lesson43.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CountryMapper {

    @Mapping(target = "code", source = "country.code")
    @Mapping(target = "russianName", source = "country.russianName")
    @Mapping(target = "englishName", source = "country.englishName")
    CountryDto toDto(Country country);

    @Mapping(target = "code", source = "country.code")
    @Mapping(target = "russianName", source = "country.russianName")
    @Mapping(target = "englishName", source = "country.englishName")
    Country toEntity(CountryDto country);

    default List<CountryDto> toDtos(List<Country> countries) {
        return countries.stream().map(this::toDto).collect(Collectors.toList());
    }
}
