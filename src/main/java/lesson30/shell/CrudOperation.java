package lesson30.shell;


import lesson30.service.CityService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class CrudOperation {

    private final CityService cityService;

    public CrudOperation(CityService cityService) {
        this.cityService = cityService;
    }


    @ShellMethod(key = {"a", "city"}, value = "add city")
    private String addCity(@ShellOption({"-russianName", "-englishName", "-code", "-pop", "-country"})
                                        String russianName, String englishName, int code, long population, String country_code) {
        return cityService.addCity(russianName, englishName, code, population, country_code);
    }

    @ShellMethod(key = {"c", "country"}, value = "add country")
    private String addCountry(@ShellOption({"-code", "-russianName","-englishName"}) String code, String russianName, String englishName) {
        return cityService.addCountry(code, russianName, englishName);
    }

    @ShellMethod(key = {"d", "del country"}, value = "Delete country by country code")
    private String deleteCountryByCode(String code) {
        return cityService.deleteCountryByCode(code);
    }

    @ShellMethod(key = {"del", "del cities"}, value = "Delete all cities by country code")
    private String deleteCitiesByCountryCode(String countryCode) {
        return cityService.deleteCitiesByCountryCode(countryCode);
    }

    @ShellMethod(key = {"r", "remove city"}, value = "Delete city by code")
    private String deleteCityByCode(@ShellOption({"-code"}) int code) {
        return cityService.deleteCityByCode(code);
    }


    @ShellMethod(key = {"f", "find all"}, value = "find all cities by country")
    private String findAllCitiesByCountryCode(@ShellOption({"-code"}) String code) {
        return cityService.findAllCitiesByCountryCode(code);
    }

    @ShellMethod(key = {"s", "code"}, value = "find city by code")
    private String findCityByCode(int code) {
        return cityService.findCityByCode(code).toString();
    }

    @ShellMethod(key = {"n", "city name"}, value = "find all city by name")
    private String findCitiesByName(String name) {
        return cityService.findCitiesByName(name);
    }

    @ShellMethod(key = {"fc", "find country"}, value = "find country by country code")
    private String findCountryByCode(String code) {
        return cityService.findCountryByCode(code);
    }


}
