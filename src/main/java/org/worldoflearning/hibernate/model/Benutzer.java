package org.worldoflearning.hibernate.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

/*
 * 
 */
@Entity
@Table(name = "Benutzer", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Benutzer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "BENUTZERNAME", length = 40, nullable = true)
	private String benutzername;

	@Column(name = "PASSWORD", length = 20, nullable = true)
	private String password;

	@Column(name = "EMail", length = 40, nullable = true)
	private String email;


	@Column(name = "ROLE", length = 20, nullable = true)
	private String role = "ROLE_USER";

	@Column(name = "INSERT_TIME", nullable = false)
	@Type(type="date")
	private Date insertTime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
