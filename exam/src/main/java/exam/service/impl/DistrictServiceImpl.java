package exam.service.impl;

import exam.dto.DistrictDto;
import exam.mapper.ExamMapper;
import exam.repository.DistrictRepository;
import exam.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final ExamMapper examMapper;

    @Override
    public List<DistrictDto> findAll() {
        return examMapper.toDistrictDtos(districtRepository.findAll());
    }

    @Override
    public DistrictDto save(DistrictDto districtDto) {
        return examMapper.toDistrictDto(districtRepository.save(examMapper.toDistrictEntity(districtDto)));
    }

    @Override
    public DistrictDto findById(long id) {
        return examMapper.toDistrictDto(districtRepository.getById(id));
    }
}
