package exam.repository;

import exam.model.HouseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Timestamp;
import java.util.List;
@RepositoryRestResource
public interface HouseDetailsRepository extends JpaRepository<HouseDetails, Long> {

    @Query("select hd from HouseDetails hd where hd.numberOfLevels = :number")
    List<HouseDetails> findAllByNumberOfLevels(int number);

    @Query("select hd from HouseDetails hd where hd.numberOfSystems = :number")
    List<HouseDetails> findAllByNumberOfSystems(int number);

    @Query("select hd from HouseDetails hd where hd.numberOfEntrances = :number")
    List<HouseDetails> findAllByNumberOfEntrances(int number);

    @Query("select hd from HouseDetails hd where hd.date = :date")
    List<HouseDetails> findAllByDate(Timestamp date);

}
