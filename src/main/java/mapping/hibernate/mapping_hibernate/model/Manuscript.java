package mapping.hibernate.mapping_hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Manuscript {

	@Id
	private Long id;
	
	private String name;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
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
