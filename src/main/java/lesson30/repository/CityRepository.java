package lesson30.repository;

import lesson30.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c " +
            "where c.country.code = :countryCode")
    List<City> findAllByCountry(String countryCode);

    @Query("select c from City c " +
            "where c.code = :code")
    City findCityByCode(int code);

    @Query("select c from City c " +
            "where c.englishName = :name " +
            "or c.russianName = :name")
    List<City> findCitiesByEnglishNameOrRussianName(String name);

}
