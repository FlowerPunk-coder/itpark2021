package exam.repository;

import exam.model.FireBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface FireBoxRepository extends JpaRepository<FireBox, Long> {

    @Query("select fb from FireBox fb where fb.hasComplete = :flag")
    List<FireBox> findAllFireBoxesByComplete(boolean flag);

    @Query("select fb from FireBox fb where fb.hasAccess = :flag")
    List<FireBox> findAllFireBoxesByAccess(boolean flag);

    @Query("select fb from FireBox fb where fb.hasDoubleRoll = :flag")
    List<FireBox> findAllFireBoxesByDoubleRoll(boolean flag);
}
