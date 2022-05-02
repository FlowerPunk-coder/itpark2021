package lesson35.controller;

import lesson35.dto.CountryDto;
import lesson35.dto.CountryPageDto;
import lesson35.service.CountryService;
import lesson35.validator.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;

@Controller
@Validated
@RequiredArgsConstructor
public class CountryPageController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public String index(Model model,
                        @PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
                        @Positive @RequestParam(required = false, defaultValue = "5") Integer size) {

        CountryPageDto allCountries = countryService.getPage(PageRequest.of(page, size));
        model.addAttribute("countries", allCountries);
        return "countries/countries";
    }

    @GetMapping("/countries/add")
    public String newCountry(Model model) {

        return "countries/country";
    }

    @GetMapping("/countries/edit")
    public String editCountry(@RequestParam("code") String code, Model model) {
        CountryDto editCountry = countryService.getByCode(code);
        model.addAttribute("country", editCountry);
        return "countries/country";
    }

    @PostMapping("/country/save")
    public String addCountry(CountryDto countryDto) {
        countryService.save(countryDto);
        return "redirect:/countries";
    }

}
