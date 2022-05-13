package exam.service;

import exam.dto.HouseDetailsDto;

import java.sql.Timestamp;
import java.util.List;

public interface HouseDetailsService {

    HouseDetailsDto findByHouseId(long id);
    List<HouseDetailsDto> findAllByDate(Timestamp date);
    List<HouseDetailsDto> findAllByNumberOfLevels(int number);
    List<HouseDetailsDto> findAllByNumberOfSystems(int number);
    List<HouseDetailsDto> findAllByNumberOfEntrance(int number);
    HouseDetailsDto save(HouseDetailsDto houseDetailsDto);
}
