package exam.service;


import exam.dto.HouseDto;

import java.util.List;

public interface HouseService {

    List<HouseDto> findByStreetId(long id);
    HouseDto findById(long id);
    HouseDto save(HouseDto houseDto);

}
