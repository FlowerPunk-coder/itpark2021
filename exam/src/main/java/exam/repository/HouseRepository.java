package exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import exam.model.House;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("select h from House h where h.street.id = :id")
    List<House> findAllByStreetId(long id);
}
