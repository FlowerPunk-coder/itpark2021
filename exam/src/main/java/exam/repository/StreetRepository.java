package exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import exam.model.Street;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface StreetRepository extends JpaRepository<Street, Long> {

    @Query("SELECT s from Street s where s.district.id = :id")
    List<Street>findAllByDistrict_Id(long id);
}
