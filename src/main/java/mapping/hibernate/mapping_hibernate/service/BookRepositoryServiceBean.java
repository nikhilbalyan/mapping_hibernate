package mapping.hibernate.mapping_hibernate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapping.hibernate.mapping_hibernate.model.Book;
import mapping.hibernate.mapping_hibernate.repository.BookRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookRepositoryServiceBean implements BookRepositoryService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Optional<Book> findOne(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,
	   readOnly = false)
	public Book create(Book book) {
		if(book.getId() != null) {
			return null;
		}
//		user.getCart().getProduct();
//		Cart cart = user.getCart();
//		cart.setUser(user);
		Book savedUser = bookRepository.save(book);
		/*if(savedUser.getId() == 4L) {
			throw new RuntimeException("Roll me back");
		}*/
		
//		User savedUser = shoppingRepository.save(user);
		return savedUser;
	}
}
