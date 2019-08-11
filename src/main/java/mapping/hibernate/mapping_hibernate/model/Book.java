package mapping.hibernate.mapping_hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "book_seq")
	private Long id;

	@OneToOne(mappedBy = "book")
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
