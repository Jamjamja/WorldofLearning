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
@Table(name = "Quest", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "QUEST_NAME" }) })
public class Quest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUEST_NAME", length = 20, nullable = true)
	private String quest_name;
	
	@Column(name = "QUEST_BESCHREIBUNG", length = 20, nullable = true)
	private String quest_beschreibung;
	
	@Column(name = "ANZAHL_PUNKTE", nullable = false, unique = true, length = 11)
	private int anzahl_punkte;
	
	/*
	 * Getter und Setter
	 */
	
	public String getQuest_name() {
		return quest_name;
	}
	public void setQuest_name(String quest_name) {
		this.quest_name = quest_name;
	}
	public String getQuest_beschreibung() {
		return quest_beschreibung;
	}
	public void setQuest_beschreibung(String quest_beschreibung) {
		this.quest_beschreibung = quest_beschreibung;
	}
	public int getAnzahl_punkte() {
		return anzahl_punkte;
	}
	public void setAnzahl_punkte(int anzahl_punkte) {
		this.anzahl_punkte = anzahl_punkte;
	}


}

