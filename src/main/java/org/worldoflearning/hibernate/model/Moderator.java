package org.worldoflearning.hibernate.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/*
 * Diese Klasse ist noch nicht implementiert.
 */
@Entity
@Table(name = "Moderator", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Moderator extends Benutzer {


	
	
	@OneToOne
	@JoinColumn(name = "GRUPPE_ID")
	private Gruppe gruppe_id;
}
