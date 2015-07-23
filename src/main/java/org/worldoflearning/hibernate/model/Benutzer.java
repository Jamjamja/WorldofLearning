package org.worldoflearning.hibernate.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/*
 * 
 */
@Entity
@Table(name = "Benutzer", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "BENUTZERNAME" }) })
public class Benutzer {

	@NotNull
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	@Id
	@Column(name = "BENUTZERNAME", unique = true, length = 40, nullable = false)
	private String benutzername;

	@NotNull
	@Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
	@Column(name = "PASSWORD", length = 20, nullable = false)
	private String password;

	@NotNull
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@+[A-Za-z0-9.-]+.+[A-Za-z]{2,4}", message = "Invalid email address.")
	@Column(name = "EMail", length = 40, nullable = false)
	private String email;

	@Column(name = "BESCHREIBUNG", length = 255, nullable = true)
	private String beschreibung; // Beschreibung, die der Benutzer selber
									// verfassen kann

	@Column(name = "Rolle", length = 40, nullable = false)
	private String rolle = "ROLE_USER";

	@Column(name = "INSERT_TIME", nullable = false)
	@Type(type = "date")
	private Date insertTime = new Date();

	@Autowired
	@OneToOne(mappedBy = "moderator")
	private Gruppe gruppe_moderator;

	@ManyToOne
	@JoinColumn(name = "gruppenname", nullable = true)
	private Gruppe gruppe;

	@ManyToMany
	@JoinTable(name = "freunde", joinColumns = @JoinColumn(name = "benuztername"), inverseJoinColumns = @JoinColumn(name = "freundename"))
	private Set<Benutzer> freunde = new HashSet<Benutzer>();

	@ManyToMany
	@JoinTable(name = "freundeVon", joinColumns = @JoinColumn(name = "freundname"), inverseJoinColumns = @JoinColumn(name = "benuztername"))
	private Set<Benutzer> freundeVon = new HashSet<Benutzer>();

	public Set<Benutzer> getFreunde() {
		return freunde;
	}

	public void setFreunde(Set<Benutzer> freunde) {
		this.freunde = freunde;
	}

	public Set<Benutzer> getFreundeVon() {
		return freundeVon;
	}

	public void setFreundeVon(Set<Benutzer> freundeVon) {
		this.freundeVon = freundeVon;
	}

	public Gruppe getGruppe_moderator() {
		return gruppe_moderator;
	}

	public void setGruppe_moderator(Gruppe gruppe_moderator) {
		this.gruppe_moderator = gruppe_moderator;
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
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
