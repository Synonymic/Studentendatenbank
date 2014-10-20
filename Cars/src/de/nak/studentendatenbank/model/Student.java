package de.nak.studentendatenbank.model;

import java.util.GregorianCalendar;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

/**
 * Studentenentität.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "STUDENT")
public class Student {
	/** Die eindeutige Identifikation. */
	private Long id;
	/** Die Matrikelnummer eines Studenten. */
	private Integer matrikelnummer;
	/** Die Userkennung eines Studenten. */
	private Integer userkennung;
	/** Der Name eines Studenten. */
	private String name;
	/** Der Vorname eines Studenten. */
	private String vorname;
	/** Die Anrede eines Studenten. */
	private String anrede;
	/** Das Geschlecht eines Studenten. */
	private String geschlecht;
	/** Das Geburtsdatum eines Studenten. */
	private GregorianCalendar geburtsdatum;
	/** Der Geburtsort eines Studenten. */
	private String geburtsort;
	/** Der Status des Studenten. */
	private Boolean status;
	/** Die Adresse eines Studenten. */
	private Adress adresse;
	/** Die Firma eines Studenten. */
	private Company firma;
	/** Das Manipel eines Studenten. */
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
	@Column(length = 10, nullable = false)
	public Integer getMatrikelnummer() {
		return matrikelnummer;
	}
	
	public void setMatrikelnummer(Integer matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	
	@Column(length = 100, nullable = false)
	public Integer getUserkennung() {
		return userkennung;
	}
	public void setUserkennung(Integer userkennung) {
		this.userkennung = userkennung;
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
	
	@Column(length = 4, nullable = false)
	public String getAnrede() {
		return anrede;
	}
	
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	
	@Column(length = 10, nullable = false)
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
	
	@Column(length = 100, nullable = false)
	public String getGeburtsort() {
		return geburtsort;
	}
	
	public void setGeburtsort(String geburtsort) {
		this.geburtsort = geburtsort;
	}
	
	@Column(length = 100, nullable = false)
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@OneToOne
	@JoinColumn(name = "ADRESSE_ID")
	public Adress getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}
	
	@ManyToOne
	@JoinColumn(name = "FIRMA_ID")
	public Company getFirma() {
		return firma;
	}
	
	public void setFirma(Company firma) {
		this.firma = firma;
	}
	
	@ManyToOne
	@JoinColumn(name = "MANIPEL_ID")
	public Manipel getManipel() {
		return manipel;
	}
	
	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}

}
