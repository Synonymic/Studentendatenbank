package de.nak.studentendatenbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Zenturienentität.
 *
 * @author Andreas Krey
 */

@Entity
@Table(name= "ZENTURIE")
public class Zenturie {
	/** Die eindeutige Identifikation. */
	private Long id;
	/** Der Name einer Zenturie. */
	private String name;
	/** Der Studiengang einer Zenturie. */
	private String studiengang;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 100, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 100, nullable = false)
	public String getStudiengang() {
		return studiengang;
	}
	
	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}
}
