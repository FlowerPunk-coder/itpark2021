package exam.repository;

import exam.model.Entrance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface EntranceRepository extends JpaRepository<Entrance, Long> {

    @Query("select e from Entrance e where e.houseDetails.id = :id")
    List<Entrance> findAllByHouseDetailsId(long id);

    @Query("select e from Entrance e where e.isWork = :flag")
    List<Entrance> findAllByWork(boolean flag);

    @Query("select e from Entrance e where e.isAtticOpen = :flag")
    List<Entrance> findAllByAtticOpen(boolean flag);

    @Query("select e from Entrance e where e.isBasementOpen = :flag")
    List<Entrance> findAllByBasementOpen(boolean flag);
}
