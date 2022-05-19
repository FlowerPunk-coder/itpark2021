package exam.service.impl;

import exam.dto.HouseDto;
import exam.mapper.HouseMapper;
import exam.model.House;
import exam.model.Street;
import exam.repository.HouseRepository;
import exam.repository.StreetRepository;
import exam.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final StreetRepository streetRepository;
    private final HouseMapper houseMapper;

    @Override
    public List<HouseDto> findByStreetId(long id) {
        return houseMapper.toHouseDtos(houseRepository.findAllByStreetId(id));
    }

    @Override
    public HouseDto findById(long id) {
        return houseMapper.toHouseDto(houseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found!")));
    }

    @Override
    @Transactional
    public HouseDto save(long streetId, HouseDto houseDto) {
        Street street = streetRepository.findById(streetId)
                    .orElseThrow(() -> new IllegalArgumentException("Street with id: " + streetId + " not found!"));
        House house = houseMapper.toHouseEntity(houseDto);
        house.setStreet(street);
        return houseMapper.toHouseDto(houseRepository.save(house));
    }

    @Override
    public HouseDto update(HouseDto houseDto) {
        return houseMapper.toHouseDto(houseRepository.save(houseMapper.toHouseEntity(houseDto)));
    }

    @Override
    public List<HouseDto> findAllByDate(Timestamp date) {
        return houseMapper.toHouseDtos(houseRepository.findAllByDate(date));
    }

}
