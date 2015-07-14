package org.worldoflearning.hibernate.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 *  
 */
@Entity
@Table(name = "Benutzer", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Gruppe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRUPPE_ID", nullable = false, unique = true, length = 11)
	private int gruppe_id;

	@Column(name = "GRUPPENNAME", length = 20, nullable = true)
	private String gruppename;

	@Column(name = "insert_time", nullable = true)
	private Date insertTime;

	@OneToMany
	@JoinColumn(name = "ID", nullable = true)
	private Benutzer id;
	
	
	
	public int getGruppe_id() {
		return gruppe_id;
	}

	public void setGruppe_id(int gruppe_id) {
		this.gruppe_id = gruppe_id;
	}

	public String getGruppename() {
		return gruppename;
	}

	public void setGruppename(String gruppename) {
		this.gruppename = gruppename;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Benutzer getId() {
		return id;
	}

	public void setId(Benutzer id) {
		this.id = id;
	}
}




