/*
package exam.mapper;


import exam.dto.*;
import exam.model.*;

import java.util.List;
import java.util.stream.Collectors;

public interface ExamMapper {



    DistrictDto toDistrictDto(District district);


    District toDistrictEntity(DistrictDto district);


    StreetDto toStreetDto(Street street);


    Street toStreetEntity(StreetDto streetDto);

    HouseDto toHouseDto(House house);

    House toHouseEntity(HouseDto house);


    HouseDetailsDto toHouseDetailsDto(HouseDetails houseDetails);
    HouseDetails toHouseDetailsEntity(HouseDetailsDto houseDetailsDto);

    EntranceDto toEntranceDto(Entrance entrance);
    Entrance toEntranceEntity(EntranceDto entrance);

    FireBoxDto toFireBoxDto(FireBox fireBox);
    FireBox toFireBoxEntity(FireBoxDto fireBox);






    default List<StreetDto> toStreetDtos(List<Street> streets) {
        return streets.stream().map(this::toStreetDto).collect(Collectors.toList());
    }

    default List<DistrictDto> toDistrictDtos(List<District> streets) {
        return streets.stream().map(this::toDistrictDto).collect(Collectors.toList());
    }

    default List<HouseDto> toHouseDtos(List<House> houses) {
        return houses.stream().map(this::toHouseDto).collect(Collectors.toList());
    }

    default List<HouseDetailsDto> toHouseDetailsDtos(List<HouseDetails> housesDetails) {
        return housesDetails.stream().map(this::toHouseDetailsDto).collect(Collectors.toList());
    }

    default List<EntranceDto> toEntranceDtos(List<Entrance> entrances) {
        return entrances.stream().map(this::toEntranceDto).collect(Collectors.toList());
    }

    default List<FireBoxDto> toFireBoxDtos(List<FireBox> fireBoxes) {
        return fireBoxes.stream().map(this::toFireBoxDto).collect(Collectors.toList());
    }



}
*/
