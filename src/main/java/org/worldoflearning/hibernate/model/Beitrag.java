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
 * Nur Getter und Setter sind bereits implementiert. Die anderen Methoden m�ssen noch implementiert werden.
 */
@Entity
@Table(name = "Beitrag", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Beitrag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "THEMA_ID", nullable = false, unique = true, length = 11)
	private int thema_id;
	
	@Column(name = "BEITRAG_ERSTELLER", length = 20, nullable = true)
	private String beitrag_ersteller;
	
	@Column(name = "BEITRAG_INHALT", length = 20, nullable = true)
	private String beitrag_inhalt;
	
	@Column(name = "BEITRAG_ERSTELLTAM", nullable = true)
	private Date beitrag_erstelltAm;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThema_Id() {
		return thema_id;
	}

	public void setThema_Id(int thema_id) {
		this.thema_id = thema_id;
	}
	
	public String getBeitrag_Ersteller(){
		return beitrag_ersteller;
	}
	
	public void setBeitrag_Ersteller(String beitrag_ersteller){
		this.beitrag_ersteller = beitrag_ersteller;
	}
	
	public String getBeitrag_Inhalt(){
		return beitrag_inhalt;
	}
	
	public void setBeitrag_Inhalt(String beitrag_inhalt){
		this.beitrag_inhalt = beitrag_inhalt;
	}
	
	public Date getBeitrag_ErstelltAm(){
		return beitrag_erstelltAm;
	}
	
	public void setBeitrag_ErstelltAm(Date beitrag_erstelltAm){
		this.beitrag_erstelltAm = beitrag_erstelltAm;
		
	}
	
	public void loeschenBeitrag(){
		
	}
	
	public void updateBeitrag(){
		
	}
	
	public void updateInhalt(){
		
	}
	
	public void erstelleBeitrag(){
		
	}

}