package mapping.hibernate.mapping_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mapping.hibernate.mapping_hibernate.model.Book;
import mapping.hibernate.mapping_hibernate.service.BookRepositoryService;



@RestController
public class BookController {

	@Autowired
	BookRepositoryService bookRepositoryService;
	
	
	@RequestMapping(value="/addProducts", method= RequestMethod.POST)
	public ResponseEntity<Book> addBookRepository(@RequestBody Book book) {
		Book createBook = bookRepositoryService.create(book);
		return new ResponseEntity<Book>(createBook, HttpStatus.CREATED);		
	}
}
