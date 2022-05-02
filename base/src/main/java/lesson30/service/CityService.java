package lesson30.service;

import lesson30.model.City;

public interface CityService {

    String addCity(String russianName, String englishName, int code, long population, String country_code);

    String addCountry(String code, String russianName, String englishName);

    String findAllCitiesByCountryCode(String code);

    City findCityByCode(int code);

    String findCitiesByName(String name);

    String findCountryByCode(String code);

    String deleteCountryByCode(String code);

    String deleteCitiesByCountryCode(String countryCode);

    String deleteCityByCode(int code);

}
