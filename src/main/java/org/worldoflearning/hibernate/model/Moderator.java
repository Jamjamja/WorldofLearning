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
 * Diese Klasse ist noch nicht implementiert.
 */
@Entity
@Table(name = "Moderator", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Moderator extends Benutzer {

	/*
	 *  Methoden
	 */
	
	public void bearbeiteGruppe(){
		
	}
	
	public void loescheGruppe(){

	}
}
