package mapping.hibernate.mapping_hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manuscript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	
//	annotations required for one to one mapping
//	@OneToOne
//	@JoinColumn(name = "id")
//	@MapsId
//	@JsonIgnore
	
	@ManyToOne
	@JoinColumn(name = "book_id", insertable = false, updatable = false)
	@JsonIgnore
	private Book book;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
