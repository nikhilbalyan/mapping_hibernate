package mapping.hibernate.mapping_hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "book_seq")
	private Long id;
	
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@OneToOne(mappedBy = "book", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private Manuscript manus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Manuscript getManus() {
		return manus;
	}

	public void setManus(Manuscript manus) {
		this.manus = manus;
	}

}
