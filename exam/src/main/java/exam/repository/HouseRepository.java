package exam.repository;


import exam.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Timestamp;
import java.util.List;

@RepositoryRestResource
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("select h from House h where h.street.id = :id")
    List<House> findAllByStreetId(long id);

    @Query("SELECT h from House h join Street s on s.id = h.street.id join District d on d.id = s.district.id where h.id = :id")
    House getFullAddressByHouseId(long id);

    @Query("select h from House h where h.date = :date")
    List<House> findAllByDate(Timestamp date);
}
