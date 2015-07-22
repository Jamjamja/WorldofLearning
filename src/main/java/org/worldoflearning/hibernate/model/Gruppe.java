package org.worldoflearning.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

/*
 *  
 */
@Entity
@Table(name = "Gruppe", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "GRUPPENNAME" }) })
public class Gruppe {

	
	@NotNull(message ="Dein Gruppenname hat keinen Namen!")
	@Size(min = 3, max = 20, message ="Dein Gruppenname ist zu lang.")
	@Id
	@Column(name = "GRUPPENNAME", length = 40, nullable = true)
	private String gruppenname;
	
	@Column(name = "KATEGORIE", length = 60, nullable = true)
	private String kategorie;
	
	@Column(name = "insert_time", nullable = true)
	private Date insertTime;

	@Autowired
	@OneToOne
	@JoinColumn(name = "moderator")
	private Benutzer moderator;

	@Autowired
	@OneToMany(mappedBy = "gruppe")
	private Set<Benutzer> benutzer = new HashSet<Benutzer>();

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	
	public String getGruppenname() {
		return gruppenname;
	}

	public void setGruppenname(String gruppenname) {
		this.gruppenname = gruppenname;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Set<Benutzer> getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Set<Benutzer> benutzer) {
		this.benutzer = benutzer;
	}

	public Benutzer getModerator() {
		return moderator;
	}

	public void setModerator(Benutzer moderator) {
		this.moderator = moderator;
	}

}
