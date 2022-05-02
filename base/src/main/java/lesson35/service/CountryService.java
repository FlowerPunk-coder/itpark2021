package lesson35.service;


import lesson35.dto.CountryDto;
import lesson35.dto.CountryPageDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {

    List<CountryDto> findAll();
    CountryPageDto getPage(Pageable pageable);
    CountryDto getByCode(String code);
    CountryDto save(CountryDto countryDto);
    void deleteByCode(String code);
}
