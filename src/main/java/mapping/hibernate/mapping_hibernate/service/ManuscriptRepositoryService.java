package mapping.hibernate.mapping_hibernate.service;

import java.util.Optional;

import mapping.hibernate.mapping_hibernate.model.Manuscript;

public interface ManuscriptRepositoryService {
	Manuscript create(Manuscript mScript, Long id);
	public Optional<Manuscript> findOne(Long id);
}
