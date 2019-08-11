package mapping.hibernate.mapping_hibernate.service;

import mapping.hibernate.mapping_hibernate.model.Book;

public interface BookRepositoryService {
	Book create(Book book);
}