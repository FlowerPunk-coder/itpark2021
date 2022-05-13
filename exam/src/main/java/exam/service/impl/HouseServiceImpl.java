package exam.service.impl;

import exam.dto.HouseDto;
import exam.mapper.ExamMapper;
import exam.repository.HouseRepository;
import exam.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final ExamMapper examMapper;

    @Override
    public List<HouseDto> findByStreetId(long id) {
        return examMapper.toHouseDtos(houseRepository.findAllByStreetId(id));
    }

    @Override
    public HouseDto findById(long id) {
        return examMapper.toHouseDto(houseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found!")));
    }

    @Override
    public HouseDto save(HouseDto houseDto) {
        return examMapper.toHouseDto(houseRepository.save(examMapper.toHouseEntity(houseDto)));
    }
}
