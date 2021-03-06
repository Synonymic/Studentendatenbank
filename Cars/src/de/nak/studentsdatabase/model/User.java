package de.nak.studentsdatabase.model;

import javax.persistence.*;

/**
 * Entity of user.
 *
 * @author Andreas Krey
 */

@Entity
@Table(name = "User")
public class User {
	/** The identifier. */
	private Long id;
	/** The name of an user. */
	private String name;
	/** The password of an user. */
	private String password;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
