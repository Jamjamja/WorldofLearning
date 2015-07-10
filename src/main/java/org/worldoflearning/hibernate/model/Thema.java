package org.worldoflearning.hibernate.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Thema", uniqueConstraints = { @UniqueConstraint(columnNames = { "THEMA_ID" }) })
public class Thema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "THEMA_ID", nullable = false, unique = true, length = 11)
	private int thema_id;

	@Column(name = "THEMA_ERSTELLER", length = 20, nullable = true)
	private int thema_ersteller;

	@Column(name = "THEMA_INHALT", length = 20, nullable = true)
	private int thema_inhalt;

	@Column(name = "insert_time", nullable = true)
	private Date thema_ErstelltAm;

	public int getThema_Id() {
		return thema_id;
	}

	public void setThema_Id(int thema_id) {
		this.thema_id = thema_id;
	}

	public int getThema_Ersteller() {
		return thema_ersteller;
	}

	public void setThema_Ersteller(int thema_ersteller) {
		this.thema_ersteller = thema_ersteller;
	}

	public int getThema_Inhalt() {
		return thema_inhalt;
	}

	public void setThema_Inhalt(int thema_inhalt) {
		this.thema_inhalt = thema_inhalt;
	}

	public Date getThema_ErstelltAm() {
		return thema_ErstelltAm;
	}

	public void setThema_ErstelltAm(Date themaErstelltAm) {
		this.thema_ErstelltAm = themaErstelltAm;
	}

	public void erstelleThema(){
		
	}
	
	public void bearbeiteThema(){
		
	}
	
	public void loescheThema(){
		
	}
	
	public void sucheThema(){
		
	}
}