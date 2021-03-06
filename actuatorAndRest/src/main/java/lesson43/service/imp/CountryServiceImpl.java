package lesson43.service.imp;

import lesson43.dto.CountryDto;
import lesson43.dto.CountryPageDto;
import lesson43.mapper.CountryMapper;
import lesson43.model.Country;
import lesson43.repository.CountryRepository;
import lesson43.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> findAll() {
        return countryMapper.toDtos(countryRepository.findAll());
    }

    @Override
    public CountryPageDto getPage(Pageable pageable) {
        Page<Country> page = countryRepository.findAll(pageable);
        return new CountryPageDto(countryMapper.toDtos(page.getContent()),
                page.getTotalPages(),
                page.getNumber(),
                page.hasNext(),
                page.hasPrevious());
    }

    @Override
    public CountryDto getByCode(String code) {
        return countryMapper.toDto(countryRepository.getById(code));
    }

    @Override
    @Transactional
    public CountryDto save(CountryDto countryDto) {
        return countryMapper.toDto(countryRepository.save(countryMapper.toEntity(countryDto)));

    }

    @Override
    @Transactional
    public void deleteByCode(String code) {
            countryRepository.deleteById(code);
    }
}
