package org.worldoflearning.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 *  
 */
@Entity
@Table(name = "Chatbeitrag", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Chatbeitrag {
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = true)
	private int id;
	
	
	/*
	@Column(name = "BEITRAG_ERSTELLTAM", nullable = true)
	private int datum;
	*/
	
	@Column(name = "NACHRICHT", length = 255, nullable = true)
	private String nachricht;
	
	@Column(name = "BENUTZERNAME", length = 20, nullable = true)
	private String benutzername;
	
	/*
	 * Getter und Setter
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNachricht() {
		return nachricht;
	}
	public void setNachricht(String nachricht) {
		this.nachricht = nachricht;
	}
	public String getBenutzername() {
		return benutzername;
	}
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	
	/*  Relationale Verkn�pfung noch nicht Implimentier
	
	@ManyToOne
	@JoinColumn(name = "CHATRAUM_ID")
	private Chatraum chatraum_id;
	
	*/

}
