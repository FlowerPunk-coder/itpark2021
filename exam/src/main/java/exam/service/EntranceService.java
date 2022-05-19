package exam.service;

import exam.dto.EntranceDto;

import java.util.List;

public interface EntranceService {

    List<EntranceDto> findAllEntrancesByHouseDetailsIdOrNew(long id);
    List<EntranceDto> findAllEntrancesByWork(boolean flag);
    List<EntranceDto> findAllEntrancesByAttic(boolean flag);
    List<EntranceDto> findAllEntrancesByBasement(boolean flag);
    EntranceDto save(EntranceDto entranceDto);
    List<EntranceDto> findAllEntrancesByHouseDetailsId(long id);
    EntranceDto findById(long id);
}
