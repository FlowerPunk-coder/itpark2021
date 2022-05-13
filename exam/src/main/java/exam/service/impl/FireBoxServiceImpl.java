package exam.service.impl;

import exam.dto.FireBoxDto;
import exam.mapper.ExamMapper;
import exam.repository.FireBoxRepository;
import exam.service.FireBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FireBoxServiceImpl implements FireBoxService {


    private final FireBoxRepository fireBoxRepository;
    private final ExamMapper examMapper;

    @Override
    public FireBoxDto findFireBoxByEntranceId(long id) {
        return examMapper.toFireBoxDto(fireBoxRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found!")));
    }

    @Override
    public List<FireBoxDto> findAllFireBoxesByComplete(boolean flag) {
        return examMapper.toFireBoxDtos(fireBoxRepository.findAllFireBoxesByComplete(flag));
    }

    @Override
    public List<FireBoxDto> findAllFireBoxesByAccess(boolean flag) {
        return examMapper.toFireBoxDtos(fireBoxRepository.findAllFireBoxesByAccess(flag));
    }

    @Override
    public List<FireBoxDto> findAllFireBoxesByDoubleRoll(boolean flag) {
        return examMapper.toFireBoxDtos(fireBoxRepository.findAllFireBoxesByDoubleRoll(flag));
    }

    @Override
    public FireBoxDto save(FireBoxDto fireBoxDto) {
        return examMapper.toFireBoxDto(fireBoxRepository.save(examMapper.toFireBoxEntity(fireBoxDto)));
    }
}
