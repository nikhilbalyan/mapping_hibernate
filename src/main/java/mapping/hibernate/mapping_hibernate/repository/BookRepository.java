package mapping.hibernate.mapping_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mapping.hibernate.mapping_hibernate.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
