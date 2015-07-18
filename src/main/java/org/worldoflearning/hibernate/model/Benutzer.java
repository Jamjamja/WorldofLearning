package org.worldoflearning.hibernate.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/*
 * 
 */
@Entity
@Table(name = "Benutzer", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "BENUTZERNAME" }) })
public class Benutzer {

	@Id
	@Column(name = "BENUTZERNAME", unique = true, length = 40, nullable = true)
	private String benutzername;

	@Column(name = "PASSWORD", length = 20, nullable = true)
	private String password;

	@Column(name = "EMail", length = 40, nullable = true)
	private String email;

	@Column(name = "Rolle", length = 40, nullable = true)
	private String rolle = "ROLE_USER";

	@Column(name = "INSERT_TIME", nullable = false)
	@Type(type = "date")
	private Date insertTime;

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

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(getRolle()));
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
