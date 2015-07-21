package org.worldoflearning.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;

/*
 *  
 */
@Entity
@Table(name = "Gruppe", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "GRUPPENNAME" }) })
public class Gruppe {


	@Id
	@Column(name = "GRUPPENNAME", length = 40, nullable = true)
	private String gruppenname;

	@Column(name = "insert_time", nullable = true)
	private Date insertTime;

	@Autowired
	@OneToMany(mappedBy = "gruppe")
	private Set<Benutzer> benutzer = new HashSet<Benutzer>();


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


}
