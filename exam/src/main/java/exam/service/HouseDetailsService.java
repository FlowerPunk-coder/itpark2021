package exam.service;

import exam.dto.HouseDetailsDto;

import java.util.List;

public interface HouseDetailsService {

    HouseDetailsDto findByHouseIdOrException(long id);
    HouseDetailsDto findByHouseIdOrNew(long id);
    List<HouseDetailsDto> findAllByNumberOfLevels(int number);
    List<HouseDetailsDto> findAllByNumberOfSystems(int number);
    List<HouseDetailsDto> findAllByNumberOfEntrance(int number);
    HouseDetailsDto save(HouseDetailsDto houseDetailsDto);
}
