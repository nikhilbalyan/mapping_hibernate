package mapping.hibernate.mapping_hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "book_seq")
	private Long id;

	@Column(name = "bookName")
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

//	one to one annotation
//	@OneToOne(mappedBy = "book", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Set<Manuscript> manus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Manuscript> getManus() {
		return manus;
	}

	public void setManus(Set<Manuscript> manus) {
		this.manus = manus;
	}

	
}
