package exam.service;

import exam.dto.FireBoxDto;

import java.util.List;

public interface FireBoxService {

    FireBoxDto findFireBoxByEntranceIdOrThrow(long id);
    FireBoxDto findFireBoxByEntranceIdOrNew(long id);
    List<FireBoxDto> findAllFireBoxesByComplete(boolean flag);
    List<FireBoxDto> findAllFireBoxesByAccess(boolean flag);
    List<FireBoxDto> findAllFireBoxesByDoubleRoll(boolean flag);
    FireBoxDto save(FireBoxDto fireBoxDto);
}
