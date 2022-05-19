package exam.service.impl;

import exam.dto.DistrictDto;
import exam.mapper.DistrictMapper;
import exam.repository.DistrictRepository;
import exam.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    @Override
    public List<DistrictDto> findAll() {
        return districtMapper.toDistrictDtos(districtRepository.findAll());
    }

    @Override
    public DistrictDto save(DistrictDto districtDto) {
        return districtMapper.toDistrictDto(districtRepository.save(districtMapper.toDistrictEntity(districtDto)));
    }

    @Override
    public DistrictDto findById(long id) {
        return districtMapper.toDistrictDto(districtRepository.getById(id));
    }
}
