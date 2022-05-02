package lesson30.service.impl;


import lesson30.model.City;
import lesson30.model.Country;
import lesson30.repository.CityRepository;
import lesson30.repository.CountryRepository;
import lesson30.service.CityService;
import lesson30.service.LocalizationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final LocalizationService localizationService;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, LocalizationService localizationService) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.localizationService = localizationService;
    }


    @Override
    public String addCity(String russianName, String englishName, int code, long population, String countryCode) {

        if (isCountry(countryCode)) {
            return localizationService.localize("empty.country", countryCode.toUpperCase());
        }
        Country country = countryRepository.findById(countryCode.toUpperCase()).get();
        cityRepository.save(new City(russianName, englishName, code, population, country));

        return localizationService.localize("add.city");
    }

    @Override
    public String addCountry(String code, String russianName, String englishName) {
        countryRepository.save(new Country(code.toUpperCase(), russianName, englishName));
        return localizationService.localize("add.country", code.toUpperCase());
    }

    @Override
    public String deleteCountryByCode(String code) {
        if (countryRepository.findById(code).isPresent()) {
            if (cityRepository.findAllByCountry(code).isEmpty()) {
                countryRepository.deleteById(code);
               return localizationService.localize("delete.country", code.toUpperCase());
            }
        }
           return localizationService.localize("notDeleted.country", code);
    }

    @Override
    public String deleteCitiesByCountryCode(String countryCode) {
        List<City> cities = cityRepository.findAllByCountry(countryCode);
        if (!cities.isEmpty()) {
            cityRepository.deleteAll(cities);
            return localizationService.localize("delete.city", cities);
        }
        return localizationService.localize("notDeleted.city", countryCode);
    }

    @Override
    public String deleteCityByCode(int code) {
        City city = cityRepository.findCityByCode(code);
        if (city != null) {
            cityRepository.deleteById(city.getId());
            return localizationService.localize("delete.city", city.toString());
        }
        return localizationService.localize("notDeleted.city", code);
    }

    @Override
    @Transactional(readOnly = true)
    public String findAllCitiesByCountryCode(String code) {
        List<City> cities = cityRepository.findAllByCountry(code);
        return result(cities, code);
    }

    @Override
    @Transactional(readOnly = true)
    public City findCityByCode(int code) {
        return cityRepository.findCityByCode(code);
    }

    @Override
    public String findCitiesByName(String name) {
        List<City> cities = cityRepository.findCitiesByEnglishNameOrRussianName(name);
        return result(cities, name);
    }

    @Override
    public String findCountryByCode(String code) {
        if (isCountry(code)) {
            return localizationService.localize("empty.country", code);
        }
        Country country = countryRepository.findById(code.toUpperCase()).get();
        return country.toString();

    }

    private boolean isCountry(String code) {

        return countryRepository.findById(code).isEmpty();
    }

    private String result(List<City> cities, String name) {
        return cities.isEmpty() ? localizationService.localize("empty.city", name)
                : localizationService.localize("text.city", name, cities);
    }


}
