package mapping.hibernate.mapping_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mapping.hibernate.mapping_hibernate.model.Manuscript;

@Repository
public interface ManuScriptRepository extends JpaRepository<Manuscript, Long>{

}
