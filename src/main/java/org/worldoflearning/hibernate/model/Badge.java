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
@Table(name = "Badge", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "BADGE_ID" }) })
public class Badge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BADGE_ID", nullable = false, unique = true, length = 11)
	private int badge_id;
	
	@Column(name = "BENOETIGTE_PUNKTE", nullable = false, unique = true, length = 11)
	private int benoetigte_punkte;
	
	@Column(name = "BADGE_NAME", length = 20, nullable = true)
	private String badge_name;
	
	
	/*
	 * Getter und Setter
	 */
	
	public String getBadge_name() {
		return badge_name;
	}
	public void setBadge_name(String badge_name) {
		this.badge_name = badge_name;
	}
	public int getBadge_id() {
		return badge_id;
	}
	public void setBadge_id(int badge_id) {
		this.badge_id = badge_id;
	}
	public int getBenoetigte_punkte() {
		return benoetigte_punkte;
	}
	public void setBenoetigte_punkte(int benoetigte_punkte) {
		this.benoetigte_punkte = benoetigte_punkte;
	}
	
}

