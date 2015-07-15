package org.worldoflearning.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * Nur Getter und Setter sind bereits implementiert. Die anderen Methoden müssen noch implementiert werden.
 */
@Entity
@Table(name = "Achievement", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "ACHIEVEMENT_ID" }) })
public class Achievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACHIEVEMENT_ID", nullable = false, unique = true, length = 11)
	private int achievement_id;
	
	@Column(name = "BENOETIGTE_PUNKTE", nullable = false, unique = true, length = 11)
	private int benoetigte_punkte;
	
	@Column(name = "ACHIEVEMENT_NAME", length = 20, nullable = true)
	private String achievement_name;
	
	/*
	 * Getter und Setter
	 */
	
	public int getAchievement_id() {
		return achievement_id;
	}
	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}
	public int getBenoetigte_punkte() {
		return benoetigte_punkte;
	}
	public void setBenoetigte_punkte(int benoetigte_punkte) {
		this.benoetigte_punkte = benoetigte_punkte;
	}
	public String getAchievement_name() {
		return achievement_name;
	}
	public void setAchievement_name(String achievement_name) {
		this.achievement_name = achievement_name;
	}
	
}
