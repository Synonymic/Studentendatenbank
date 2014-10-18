package de.nak.studentendatenbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * Adressenenentit‰t.
 *
 * @author Andreas Krey
 */

@Entity 
@Table(name= "ADRESSE")
public class Adresse {
	/** Die eindeutige Identifikation. */
	private Long id;
	/** Der Adresszusatz. */
	private String adresszusatz;
	/** Der Straﬂenname. */
	private String straﬂe;
	/** Die Postleitzahl des Ortes. */
	private Integer plz;
	/** Der Ortsname. */
	private String ort;
	/** Die Telefonnummer. */
	private Integer telefon;
	/** Die Faxnummer. */
	private Integer fax;
	/** Die E-Mailadresse. */
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 100, nullable = true)
	public String getAdresszusatz() {
		return adresszusatz;
	}
	
	public void setAdresszusatz(String adresszusatz) {
		this.adresszusatz = adresszusatz;
	}
	
	@Column(length = 100, nullable = false)
	public String getStraﬂe() {
		return straﬂe;
	}
	
	public void setStraﬂe(String straﬂe) {
		this.straﬂe = straﬂe;
	}
	
	@NaturalId
	@Column(length = 5, nullable = false)
	public Integer getPlz() {
		return plz;
	}
	
	public void setPlz(Integer plz) {
		this.plz = plz;
	}
	
	@NaturalId
	@Column(length = 100, nullable = false)
	public String getOrt() {
		return ort;
	}
	
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	@Column(length = 100, nullable = false)
	public Integer getTelefon() {
		return telefon;
	}
	
	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}
	
	@Column(length = 100, nullable = true)
	public Integer getFax() {
		return fax;
	}
	
	public void setFax(Integer fax) {
		this.fax = fax;
	}
	
	@Column(length = 100, nullable = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
