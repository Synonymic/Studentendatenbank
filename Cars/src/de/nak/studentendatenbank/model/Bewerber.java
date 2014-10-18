package de.nak.studentendatenbank.model;

import java.util.GregorianCalendar;

import javax.persistence.*;

/**
 * Bewerberentität.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "Bewerber")
public class Bewerber {
	/** Die eindeutige Identifikation. */
	private Long id;
	/** Der Name eines Bewerbers. */
	private String name;
	/** Der Vorname eines Bewerbers. */
	private String vorname;
	/** Die Anrede eines Bewerbers. */
	private String anrede;
	/** Das Geschlecht eines Bewerbers. */
	private String geschlecht;
	/** Das Geburtsdatum eines Bewerbers. */
	private GregorianCalendar geburtsdatum;
	/** Der Geburtsort eines Bewerbers. */
	private String geburtsort;
	/** Die Adresse eines Bewerbers. */
	private Adresse adresse;
	
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
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	@Column(length = 100, nullable = false)
	public String getAnrede() {
		return anrede;
	}
	
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	
	@Column(length = 100, nullable = false)
	public String getGeschlecht() {
		return geschlecht;
	}
	
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	@Column(length = 10, nullable = false)
	public GregorianCalendar getGeburtsdatum() {
		return geburtsdatum;
	}
	
	public void setGeburtsdatum(GregorianCalendar geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	@Column(length = 100, nullable = true)
	public String getGeburtsort() {
		return geburtsort;
	}
	
	public void setGeburtsort(String geburtsort) {
		this.geburtsort = geburtsort;
	}
	
	@OneToOne
	@JoinColumn(name = "ADRESSE_ID")
	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
