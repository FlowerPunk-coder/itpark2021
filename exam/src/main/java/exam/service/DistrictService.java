package exam.service;

import exam.dto.DistrictDto;

import java.util.List;

public interface DistrictService {

    List<DistrictDto> findAll();

    DistrictDto findById(long id);

    DistrictDto save(DistrictDto districtDto);
}
