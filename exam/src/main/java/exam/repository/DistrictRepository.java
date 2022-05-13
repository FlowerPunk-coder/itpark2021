package exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import exam.model.District;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DistrictRepository extends JpaRepository<District, Long> {

}
