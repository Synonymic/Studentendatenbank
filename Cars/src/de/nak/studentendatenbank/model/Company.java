package de.nak.studentendatenbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Firmenentität.
 *
 * @author Andreas Krey
 */

@Entity
@Table(name= "FIRMA")
public class Company {
	/** Die eindeutige Identifikation. */
	private Long id;
	/** Der Name einer Firma. */
	private String name;
	/** Der Zusatz für einer Firma. */
	private String zusatz;
	/** Das Kürzel einer Firma. */
	private String firmaKurz;
	/** Der Ansprechpartner einer Firma. */
	private String ansprechpartner;
	/** Die Adresse einer Firma */
	private Adress adresse;
	
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
	public String getZusatz() {
		return zusatz;
	}
	
	@Column(length = 100, nullable = false)
	public void setZusatz(String zusatz) {
		this.zusatz = zusatz;
	}
	
	@Column(length = 20, nullable = false)
	public String getFirmaKurz() {
		return firmaKurz;
	}
	
	public void setFirmaKurz(String firmaKurz) {
		this.firmaKurz = firmaKurz;
	}
	
	@Column(length = 100, nullable = false)
	public String getAnsprechpartner() {
		return ansprechpartner;
	}
	
	public void setAnsprechpartner(String ansprechpartner) {
		this.ansprechpartner = ansprechpartner;
	}
	
	@OneToOne
	@JoinColumn(name = "ADRESSE_ID")
	public Adress getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}
	
	

}
