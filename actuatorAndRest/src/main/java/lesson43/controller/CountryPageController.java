package lesson43.controller;


import lesson43.model.Country;
import lesson43.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CountryPageController {

    private final CountryRepository countryRepository;

    @GetMapping("/countries")
    public String allCountries() {
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
