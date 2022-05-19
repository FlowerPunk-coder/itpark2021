package exam.service.impl;

import exam.dto.EntranceDto;
import exam.mapper.EntranceMapper;
import exam.repository.EntranceRepository;
import exam.service.EntranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntranceServiceImpl implements EntranceService {

    private final EntranceRepository entranceRepository;
    private final EntranceMapper entranceMapper;

    @Override
    public List<EntranceDto> findAllEntrancesByHouseDetailsIdOrNew(long id) {
        return entranceMapper.toEntranceDtos(entranceRepository.findAllByHouseDetailsIdOrNew(id));
    }

    @Override
    public List<EntranceDto> findAllEntrancesByWork(boolean flag) {
        return entranceMapper.toEntranceDtos(entranceRepository.findAllByWork(flag));
    }

    @Override
    public List<EntranceDto> findAllEntrancesByAttic(boolean flag) {
        return entranceMapper.toEntranceDtos(entranceRepository.findAllByAtticOpen(flag));
    }

    @Override
    public List<EntranceDto> findAllEntrancesByBasement(boolean flag) {
        return entranceMapper.toEntranceDtos(entranceRepository.findAllByBasementOpen(flag));
    }

    @Override
    public EntranceDto save(EntranceDto entranceDto) {
        return entranceMapper.toEntranceDto(entranceRepository.save(entranceMapper.toEntranceEntity(entranceDto)));
    }
}
