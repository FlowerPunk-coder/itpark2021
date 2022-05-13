package exam.service.impl;

import exam.dto.EntranceDto;
import exam.mapper.ExamMapper;
import exam.repository.EntranceRepository;
import exam.service.EntranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntranceServiceImpl implements EntranceService {

    private final EntranceRepository entranceRepository;
    private final ExamMapper examMapper;

    @Override
    public List<EntranceDto> findAllEntrancesByHouseDetailsId(long id) {
        return examMapper.toEntranceDtos(entranceRepository.findAllByHouseDetailsId(id));
    }

    @Override
    public List<EntranceDto> findAllEntrancesByWork(boolean flag) {
        return examMapper.toEntranceDtos(entranceRepository.findAllByWork(flag));
    }

    @Override
    public List<EntranceDto> findAllEntrancesByAttic(boolean flag) {
        return examMapper.toEntranceDtos(entranceRepository.findAllByAtticOpen(flag));
    }

    @Override
    public List<EntranceDto> findAllEntrancesByBasement(boolean flag) {
        return examMapper.toEntranceDtos(entranceRepository.findAllByBasementOpen(flag));
    }

    @Override
    public EntranceDto save(EntranceDto entranceDto) {
        return examMapper.toEntranceDto(entranceRepository.save(examMapper.toEntranceEntity(entranceDto)));
    }
}
