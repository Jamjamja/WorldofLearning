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
@Table(name = "User", uniqueConstraints = { @UniqueConstraint(columnNames = { "FACHBEREICH_ID" }) })
public class Fachbereich {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FACHBEREICH_ID", nullable = false, unique = true, length = 11)
	private int fachbereich_id;

	@Column(name = "FACHBEREICH_NAME", length = 20, nullable = true)
	private String fachbereich_name;

	public int getId() {
		return fachbereich_id;
	}

	public void setId(int fachbereich_id) {
		this.fachbereich_id = fachbereich_id;
	}

	public String getName() {
		return fachbereich_name;
	}

	public void setName(String fachbereich_name) {
		this.fachbereich_name = fachbereich_name;
	}

}