package de.nak.studentendatenbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Manipelentität.
 *
 * @author Andreas Krey
 */

@Entity
@Table(name= "MANIPEL")
public class Manipel {
	/** Die eindeutige Identifikation. */
	private Long id;
	/** Der Jahrgang eines Manipels. */
	private Integer jahrgang;
	/** Die Zenturie eines Manipels. */
	private Zenturie zenturie;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 4, nullable = false)
	public Integer getJahrgang() {
		return jahrgang;
	}
	
	public void setJahrgang(Integer jahrgang) {
		this.jahrgang = jahrgang;
	}

	@OneToMany
	@JoinColumn(name = "ZENTURIE_ID")
	public Zenturie getZenturie() {
		return zenturie;
	}

	public void setZenturie(Zenturie zenturie) {
		this.zenturie = zenturie;
	}
	

}
