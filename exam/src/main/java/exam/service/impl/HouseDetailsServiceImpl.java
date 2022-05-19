package exam.service.impl;

import exam.dto.HouseDetailsDto;
import exam.mapper.HouseDetailsMapper;
import exam.mapper.HouseMapper;
import exam.model.House;
import exam.model.HouseDetails;
import exam.repository.HouseDetailsRepository;
import exam.repository.HouseRepository;
import exam.service.HouseDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseDetailsServiceImpl implements HouseDetailsService {

    private final HouseDetailsRepository houseDetailsRepository;
    private final HouseDetailsMapper houseDetailsMapper;
    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;

    @Override
    public HouseDetailsDto findByHouseIdOrException(long id) {
        return houseDetailsMapper.toHouseDetailsDto(houseDetailsRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не найдены подробности дома с id = " + id)));
    }

    @Override
    public HouseDetailsDto findByHouseIdOrNew(long id) {
        return houseDetailsMapper.toHouseDetailsDto(houseDetailsRepository
                .findById(id).orElse(new HouseDetails()));
    }


    @Override
    public List<HouseDetailsDto> findAllByNumberOfLevels(int number) {
        return houseDetailsMapper.toHouseDetailsDtos(houseDetailsRepository.findAllByNumberOfLevels(number));
    }

    @Override
    public List<HouseDetailsDto> findAllByNumberOfSystems(int number) {
        return houseDetailsMapper.toHouseDetailsDtos(houseDetailsRepository.findAllByNumberOfSystems(number));
    }

    @Override
    public List<HouseDetailsDto> findAllByNumberOfEntrance(int number) {
        return houseDetailsMapper.toHouseDetailsDtos(houseDetailsRepository.findAllByNumberOfEntrances(number));
    }

    @Override
    @Transactional
    public HouseDetailsDto save(HouseDetailsDto houseDetailsDto) {
        House house = houseRepository.getById(houseDetailsDto.getId());
        houseDetailsDto.setHouse(houseMapper.toHouseDto(house));
        return houseDetailsMapper.toHouseDetailsDto(houseDetailsRepository
                .save(houseDetailsMapper.toHouseDetailsEntity(houseDetailsDto)));
    }

}
