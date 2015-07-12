package org.worldoflearning.hibernate.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 *  
 */
@Entity
@Table(name = "Chatbeitrag", uniqueConstraints = { @UniqueConstraint(columnNames = { "DATUM" }) })
public class Chatbeitrag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BEITRAG_ERSTELLTAM", nullable = true)
	private Date datum;
	
	@Column(name = "NACHRICHT", length = 20, nullable = true)
	private String nachricht;
	
	@Column(name = "BENUTZERNAME", length = 20, nullable = true)
	private String benutzername;
	
	/*
	 * Getter und Setter
	 */
	
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
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
	
	/*
	 * Methoden
	 */

	public void erstelleChatbeitrag(){
		
	}
}
