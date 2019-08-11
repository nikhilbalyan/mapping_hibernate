package mapping.hibernate.mapping_hibernate.service;

import java.util.Optional;

import mapping.hibernate.mapping_hibernate.model.Book;

public interface BookRepositoryService {
	Book create(Book book);
	Optional<Book> findOne(Long id);
}