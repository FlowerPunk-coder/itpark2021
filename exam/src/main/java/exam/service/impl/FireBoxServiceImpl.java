package exam.service.impl;

import exam.dto.FireBoxDto;
import exam.mapper.FireBoxMapper;
import exam.model.FireBox;
import exam.repository.FireBoxRepository;
import exam.service.FireBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FireBoxServiceImpl implements FireBoxService {


    private final FireBoxRepository fireBoxRepository;
    private final FireBoxMapper fireBoxMapper;

    @Override
    public FireBoxDto findFireBoxByEntranceIdOrThrow(long id) {
        return fireBoxMapper.toFireBoxDto(fireBoxRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found!")));
    }

    @Override
    public FireBoxDto findFireBoxByEntranceIdOrNew(long id) {
        return fireBoxMapper.toFireBoxDto(fireBoxRepository.findById(id).orElse(new FireBox()));
    }

    @Override
    public List<FireBoxDto> findAllFireBoxesByComplete(boolean flag) {
        return fireBoxMapper.toFireBoxDtos(fireBoxRepository.findAllFireBoxesByComplete(flag));
    }

    @Override
    public List<FireBoxDto> findAllFireBoxesByAccess(boolean flag) {
        return fireBoxMapper.toFireBoxDtos(fireBoxRepository.findAllFireBoxesByAccess(flag));
    }

    @Override
    public List<FireBoxDto> findAllFireBoxesByDoubleRoll(boolean flag) {
        return fireBoxMapper.toFireBoxDtos(fireBoxRepository.findAllFireBoxesByDoubleRoll(flag));
    }

    @Override
    public FireBoxDto save(FireBoxDto fireBoxDto) {
        return fireBoxMapper.toFireBoxDto(fireBoxRepository.save(fireBoxMapper.toFireBoxEntity(fireBoxDto)));
    }
}
