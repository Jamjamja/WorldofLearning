package org.worldoflearning.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Thema", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "THEMA_ID" }) })
public class Thema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "THEMA_ID", nullable = false, unique = true)
	private int thema_id;

	@Column(name = "THEMA_ERSTELLER", nullable = false, length = 20)
	private String thema_ersteller;

	@NotNull(message ="Dein Thema hat keinen Namen!")	
	@Size(min = 3, max = 255, message ="Du hast die maximale Anzahl an Zeichen erreicht.")
	@Column(name = "THEMA_INHALT", nullable = false, length = 255)
	private String thema_inhalt;

	@Column(name = "ERSTELLT_AM", nullable = true)
	private Date thema_ErstelltAm;

	@Autowired
	@OneToMany(mappedBy = "thema")
	@Cascade({ CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private Set<Beitrag> beitrag = new HashSet<Beitrag>();

	/*
	 * Getter und Setter
	 */

	public int getThema_id() {
		return thema_id;
	}

	public void setThema_id(int thema_id) {
		this.thema_id = thema_id;
	}

	public String getThema_ersteller() {
		return thema_ersteller;
	}

	public void setThema_ersteller(String thema_ersteller) {
		this.thema_ersteller = thema_ersteller;
	}

	public String getThema_inhalt() {
		return thema_inhalt;
	}

	public void setThema_inhalt(String thema_inhalt) {
		this.thema_inhalt = thema_inhalt;
	}

	public Date getThema_ErstelltAm() {
		return thema_ErstelltAm;
	}

	public void setThema_ErstelltAm(Date themaErstelltAm) {
		this.thema_ErstelltAm = themaErstelltAm;
	}

	public Set<Beitrag> getBeitrag() {
		return beitrag;
	}

	public void setBeitrag(Set<Beitrag> beitrag) {
		this.beitrag = beitrag;
	}

}