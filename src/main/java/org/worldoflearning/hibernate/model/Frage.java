package org.worldoflearning.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 *  Die Methoden bis auf Getter und Setter muessen noch implementiert werden.
 */
@Entity
@Table(name = "Frage", catalog = "testdb", uniqueConstraints = { @UniqueConstraint(columnNames = { "FRAGE_ID" }) })
public class Frage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRAGE_ID", nullable = false, unique = true, length = 11)
	private int frage_id;

	@Column(name = " FRAGE_NAME ", length = 20, nullable = true)
	private String frage_name;

	@Column(name = " FRAGE_BEWERTUNG ", length = 20, nullable = true)
	private float frage_bewertung;

	@Column(name = " FRAGE_ANZAHLBEWERTUNG ", nullable = false, unique = true, length = 11)
	private int frage_anzahlbewertung;

	@Column(name = " FRAGE_TEXT", length = 20, nullable = true)
	private String frage_text;

	@Column(name = " FRAGE_ANTWORT_M�GLICHKEITEN", length = 20, nullable = true)
	private String frage_antwort_moeglichkeiten;

	@Column(name = " name ", length = 20, nullable = true)
	private String frage_korrekte_antwort;

	
//	@ManyToOne
//	@JoinColumn(name = "TEST_ID")
//	private Test test_id;
	
	/*
	 * Getter und Setter
	 */

	public String getFrage_name() {
		return frage_name;
	}

	public void setFrage_name(String frage_name) {
		this.frage_name = frage_name;
	}

	public int getFrage_id() {
		return frage_id;
	}

	public void setFrage_id(int frage_id) {
		this.frage_id = frage_id;
	}

	public float getFrage_bewertung() {
		return frage_bewertung;
	}

	public void setFrage_bewertung(float frage_bewertung) {
		this.frage_bewertung = frage_bewertung;
	}

	public int getFrage_anzahlbewertung() {
		return frage_anzahlbewertung;
	}

	public void setFrage_anzahlbewertung(int frage_anzahlbewertung) {
		this.frage_anzahlbewertung = frage_anzahlbewertung;
	}

	public String getFrage_text() {
		return frage_text;
	}

	public void setFrage_text(String frage_text) {
		this.frage_text = frage_text;
	}

	public String getFrage_antwort_moeglichkeiten() {
		return frage_antwort_moeglichkeiten;
	}

	public void setFrage_antwort_moeglichkeiten(String frage_antwort_moeglichkeiten) {
		this.frage_antwort_moeglichkeiten = frage_antwort_moeglichkeiten;
	}

	public String getFrage_korrekte_antwort() {
		return frage_korrekte_antwort;
	}

	public void setFrage_korrekte_antwort(String frage_korrekte_antwort) {
		this.frage_korrekte_antwort = frage_korrekte_antwort;
	}

	

}
