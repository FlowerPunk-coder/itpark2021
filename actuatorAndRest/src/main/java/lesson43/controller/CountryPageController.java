package lesson43.controller;


import lesson43.dto.CountryPageDto;
import lesson43.model.Country;
import lesson43.repository.CountryRepository;
import lesson43.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Controller
@RequiredArgsConstructor
public class CountryPageController {

    private final CountryRepository countryRepository;
    private final CountryService countryService;

    @GetMapping("/countries")
    public String allCountries(Model model,
                               @PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
                               @Positive @RequestParam(required = false, defaultValue = "5") Integer size) {

        CountryPageDto allCountries = countryService.getPage(PageRequest.of(page, size));
        model.addAttribute("countries", allCountries);
        return "countries/countries";
    }

    @GetMapping("/countries/add")
    public String addCountry() {
        return "countries/country";
    }


    @PostMapping("country/save")
    public String save(Country country) {
        countryRepository.save(country);
        return "redirect:/countries";
    }
}
