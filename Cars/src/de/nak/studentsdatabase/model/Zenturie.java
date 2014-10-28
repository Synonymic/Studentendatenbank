package de.nak.studentsdatabase.model;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;


/**
 * Entity of a zenturie.
 *
 * @author Andreas Krey
 */

@Entity
public class Zenturie {
	/** The identifier. */
	private Long id;
	/** The name of a zenturie. */
	private String name;
	/** The associated manipel of a zenturie. */
	private Manipel manipel;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NaturalId
	@Column(length = 100, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@NaturalId
	@ManyToOne
	@JoinColumn(name = "MANIPEL_ID")
	public Manipel getManipel() {
		return manipel;
	}

	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}
}
