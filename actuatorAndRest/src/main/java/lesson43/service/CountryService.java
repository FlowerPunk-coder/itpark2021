package lesson43.service;


import lesson43.dto.CountryDto;
import lesson43.dto.CountryPageDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {

    List<CountryDto> findAll();
    CountryPageDto getPage(Pageable pageable);
    CountryDto getByCode(String code);
    CountryDto save(CountryDto countryDto);
    void deleteByCode(String code);
}
