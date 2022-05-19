package exam.service.impl;

import exam.dto.StreetDto;
import exam.mapper.DistrictMapper;
import exam.mapper.HouseMapper;
import exam.mapper.StreetMapper;
import exam.model.District;
import exam.model.Street;
import exam.repository.DistrictRepository;
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
    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;
    private final StreetMapper streetMapper;
    private final HouseMapper houseMapper;

    @Override
    public List<StreetDto> getStreetsByDistrictName(Long id) {
        return streetMapper.toStreetDtos(streetRepository.findAllByDistrict_Id(id));
    }

    @Override
    public List<StreetDto> findAll() {
        return streetMapper.toStreetDtos(streetRepository.findAll());
    }

    @Override
    @Transactional
    public StreetDto save(long districtId, StreetDto streetDto) {

        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new IllegalArgumentException("District with id: " + districtId + " not found!"));
        Street street = streetMapper.toStreetEntity(streetDto);
        street.setDistrict(district);
        return streetMapper.toStreetDto(streetRepository.save(street));
    }
}
