package lesson43.repository;


import lesson43.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "countries")
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByRussianName(@RequestParam("rusName") String rusName);

    Country findByCode(@RequestParam("code") String code);
}
