package exam.service;


import exam.dto.HouseDto;

import java.sql.Timestamp;
import java.util.List;

public interface HouseService {

    List<HouseDto> findByStreetId(long id);
    HouseDto findById(long id);
    HouseDto save(long streetId, HouseDto houseDto);
    HouseDto update(HouseDto houseDto);
    List<HouseDto> findAllByDate(Timestamp date);
}
