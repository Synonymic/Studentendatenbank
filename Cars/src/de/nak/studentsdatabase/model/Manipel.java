package de.nak.studentsdatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Entity of a manipel.
 *
 * @author Andreas Krey
 */

@Entity
@Table(name= "MANIPEL")
public class Manipel {
	/** The identifier. */
	private Long id;
	/** The vintage of a manipel. */
	private Integer vintage;
	/** The zenturie of a manipel. */
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
	public Integer getVintage() {
		return vintage;
	}
	
	public void setVintage(Integer vintage) {
		this.vintage = vintage;
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
