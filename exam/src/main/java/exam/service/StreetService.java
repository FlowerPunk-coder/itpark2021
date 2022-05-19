package exam.service;

import exam.dto.StreetDto;

import java.util.List;

public interface StreetService {

    List<StreetDto> getStreetsByDistrictName(Long id);

    List<StreetDto> findAll();

    StreetDto save(long districtId, StreetDto streetDto);

}
