package mapping.hibernate.mapping_hibernate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mapping.hibernate.mapping_hibernate.model.Book;
import mapping.hibernate.mapping_hibernate.model.Manuscript;
import mapping.hibernate.mapping_hibernate.repository.BookRepository;
import mapping.hibernate.mapping_hibernate.repository.ManuScriptRepository;
import mapping.hibernate.mapping_hibernate.service.BookRepositoryService;
import mapping.hibernate.mapping_hibernate.service.ManuscriptRepositoryService;



@RestController
public class BookController {

	@Autowired
	BookRepositoryService bookRepositoryService;
	
	@Autowired
	ManuscriptRepositoryService manuScriptRepositoryService;
	
	@Autowired
	ManuScriptRepository manuScrpt;
	
	@Autowired
	BookRepository bookRepo;
	
	
	@RequestMapping(value="/addProducts", method= RequestMethod.POST)
	public ResponseEntity<Book> addBookRepository(@RequestBody Book book) {
		Book createBook = bookRepositoryService.create(book);
		return new ResponseEntity<Book>(createBook, HttpStatus.CREATED);		
	}
	
	@RequestMapping(value="/{bookId}/addBook", method = RequestMethod.POST)
	public Optional<Object> addBookManuscrpt(@PathVariable Long bookId, 
			@RequestBody Manuscript manuscript) {
		return bookRepo.findById(bookId)
				.map(book -> {
					manuscript.setBook(book);
					return manuScrpt.save(manuscript); 
				});
	}
	
	@RequestMapping(value="/getBook/{bookId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Book>> getAllBook(@PathVariable Long bookId) {
		Optional<Book> bookDetails = bookRepositoryService.findOne(bookId);
		if(bookDetails == null) {
			return new ResponseEntity<Optional<Book>>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<Optional<Book>>(bookDetails, HttpStatus.OK);
	}
}
