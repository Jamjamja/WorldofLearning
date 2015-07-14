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
@Table(name = "Chatraum", uniqueConstraints = { @UniqueConstraint(columnNames = { "CHATRAUM_ID" }) })
public class Chatraum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHATRAUM_ID", nullable = false, unique = true, length = 11)
	private int chatraum_id;
	
	@Column(name = "CHATRAUM_THEMA", length = 20, nullable = true)
	private String chatraum_thema;
	
	/*
	 * Getter und Setter
	 */
	
	public int getChatraum_id() {
		return chatraum_id;
	}

	public void setChatraum_id(int chatraum_id) {
		this.chatraum_id = chatraum_id;
	}

	public String getChatraum_thema() {
		return chatraum_thema;
	}

	public void setChatraum_thema(String chatraum_thema) {
		this.chatraum_thema = chatraum_thema;
	}
	
	/*
	 * Methoden
	 */
	
	public void chatraumAlarm(){
		
	}
	
	public void erstelleChatraum(){
		
	}
}
