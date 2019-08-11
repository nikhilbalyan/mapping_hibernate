package mapping.hibernate.mapping_hibernate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapping.hibernate.mapping_hibernate.model.Manuscript;
import mapping.hibernate.mapping_hibernate.repository.BookRepository;
import mapping.hibernate.mapping_hibernate.repository.ManuScriptRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ManuscriptRepositoryBean implements ManuscriptRepositoryService {

	@Autowired
	ManuScriptRepository manuScrpt;
	
	@Autowired
	private BookRepository bookRepository;

	 
	
	@Override
	public Optional<Manuscript> findOne(Long id) {
		Optional<Manuscript> manus = manuScrpt.findById(id);
		return manus;
	}


	@Override
	public Manuscript create(Manuscript mScript, Long id) {
		// TODO Auto-generated method stub
//		return bookRepository.findById(id)
//				.map(book -> {
					
//				})
		return new Manuscript();
	}
}
