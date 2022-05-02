package lesson35.controller.rest;

import lesson35.service.CountryService;
import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class RestCountryController {

    private final CountryService countryService;

    @DeleteMapping("delete/{code}")
    public void delCountry(@PathVariable("code") String code) {
        countryService.deleteByCode(code);
    }
}
