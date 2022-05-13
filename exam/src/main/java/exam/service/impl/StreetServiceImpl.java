package exam.service.impl;

import exam.dto.StreetDto;
import exam.mapper.ExamMapper;
import exam.repository.StreetRepository;
import exam.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;
    private final ExamMapper examMapper;

    @Override
    public List<StreetDto> getStreetsByDistrictName(Long id) {
        return examMapper.toStreetDtos(streetRepository.findAllByDistrict_Id(id));
    }

    @Override
    public List<StreetDto> findAll() {
        return examMapper.toStreetDtos(streetRepository.findAll());
    }

    @Override
    @Transactional
    public StreetDto save(StreetDto streetDto) {
        return examMapper.toStreetDto(streetRepository.save(examMapper.toStreetEntity(streetDto)));
    }
}
