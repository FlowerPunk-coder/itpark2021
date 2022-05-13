package exam.service.impl;

import exam.dto.HouseDetailsDto;
import exam.mapper.ExamMapper;
import exam.repository.HouseDetailsRepository;
import exam.service.HouseDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseDetailsServiceImpl implements HouseDetailsService {

    private final HouseDetailsRepository houseDetailsRepository;
    private final ExamMapper examMapper;

    @Override
    public HouseDetailsDto findByHouseId(long id) {
        return examMapper.toHouseDetailsDto(houseDetailsRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не найдены подробности дома с id = " + id)));
    }

    @Override
    public List<HouseDetailsDto> findAllByDate(Timestamp date) {
        return examMapper.toHouseDetailsDtos(houseDetailsRepository.findAllByDate(date));
    }

    @Override
    public List<HouseDetailsDto> findAllByNumberOfLevels(int number) {
        return examMapper.toHouseDetailsDtos(houseDetailsRepository.findAllByNumberOfLevels(number));
    }

    @Override
    public List<HouseDetailsDto> findAllByNumberOfSystems(int number) {
        return examMapper.toHouseDetailsDtos(houseDetailsRepository.findAllByNumberOfSystems(number));
    }

    @Override
    public List<HouseDetailsDto> findAllByNumberOfEntrance(int number) {
        return examMapper.toHouseDetailsDtos(houseDetailsRepository.findAllByNumberOfEntrances(number));
    }

    @Override
    public HouseDetailsDto save(HouseDetailsDto houseDetailsDto) {
        return examMapper.toHouseDetailsDto(houseDetailsRepository
                .save(examMapper.toHouseDetailsEntity(houseDetailsDto)));
    }
}
