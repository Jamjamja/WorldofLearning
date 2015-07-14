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
@Table(name = "Gruppe", uniqueConstraints = { @UniqueConstraint(columnNames = { "GRUPPE_ID" }) })
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
	@JoinColumn(name = "ID")
	private Benutzer id;
}