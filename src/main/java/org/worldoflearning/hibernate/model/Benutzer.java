package org.worldoflearning.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.worldoflearning.hibernate.model.BenutzerRolle;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
/*
 * 
 */
@Entity
@Table(name = "Benutzer", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "BENUTZERNAME" }) })
public class Benutzer {

	@Id
	@Column(name = "BENUTZERNAME",unique = true, length = 40, nullable = true)
	private String benutzername;

	@Column(name = "PASSWORD", length = 20, nullable = true)
	private String password;

	@Column(name = "EMail", length = 40, nullable = true)
	private String email;

	@Column(name = "INSERT_TIME", nullable = false)
	@Type(type = "date")
	private Date insertTime;

	
	@Autowired
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "benutzer")
	private Set<BenutzerRolle> benutzerRolle = new HashSet<BenutzerRolle>(0);
	
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

	public Set<BenutzerRolle> BenutzerRolle() {
		return benutzerRolle;
	}

	public void setBenutzerRolle(Set<BenutzerRolle> benutzerRolle) {
		this.benutzerRolle = benutzerRolle;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
