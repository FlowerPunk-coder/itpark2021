package lesson41.controller;


import lesson41.dto.CountryDto;
import lesson41.mapper.CountryMapper;
import lesson41.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@Controller
@Validated
@RequiredArgsConstructor
public class CountryPageController {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @GetMapping("/countries")
    public String index() {
        return "countries/countries";
    }

    @GetMapping("/countries/add")
    public String newCountry() {
        return "countries/country";
    }

    @GetMapping("/countries/edit")
    public String editCountry(@RequestParam("code") String code, Model model) {
        model.addAttribute("country", countryRepository.findById(code));
        return "countries/country";
    }

    @PostMapping("/country/save")
    public Mono<String> addCountry(CountryDto countryDto) {
        return countryRepository.save(countryMapper.toEntity(countryDto))
                .map(country -> "redirect:/countries");

    }

}
