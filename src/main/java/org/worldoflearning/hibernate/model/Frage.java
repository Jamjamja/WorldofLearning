package org.worldoflearning.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;

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

	@Column(name = "FRAGENTEXT", length = 255, nullable = false)
	private String fragenText;
	
	@Column(name = "KATEGORIE", length = 100, nullable = false)
	private String kategorie;
//
//	@Column(name = " BEWERTUNG ", length = 5, nullable = true)
//	private float bewertung;
//
//	@Column(name = " ANZAHLBEWERTUNGEN ", nullable = false, unique = true, length = 11)
//	private int anzahlBewertungen;

	
	@Column(name = "ANTWORT_A", length = 255, nullable = false)
	private String antwort_a;

//	@Column(name = " A_RICHTIG ", nullable = false)
//	private boolean a_richtig;
	
	
	@Column(name ="ANTWORT_B", length = 255, nullable = false)
	private String antwort_b;

	@Column(name = " FRAGE_NAME ", length = 20, nullable = true)
	private String frage_name;

	@Column(name = " FRAGE_BEWERTUNG ", length = 20, nullable = true)
	private float frage_bewertung;

	@Column(name = " FRAGE_ANZAHLBEWERTUNG ", nullable = false, unique = true, length = 11)
	private int frage_anzahlbewertung;


	@Column(name = " FRAGE_TEXT", length = 20, nullable = true)
	private String frage_text;

	@Column(name ="ANTWORT_C", length = 255, nullable = false)
	private String antwort_c;

	@Column(name = " FRAGE_ANTWORT_MOEGLICHKEITEN", length = 20, nullable = true)
	private String frage_antwort_moeglichkeiten;

	@Column(name = " name ", length = 20, nullable = true)
	private String frage_korrekte_antwort;
	
//	@ManyToOne
//	@JoinColumn(name = "TEST_ID")
//	private Test test_id;
	
	@Column(name ="ANTWORT_D", length = 255, nullable = false)
	private String antwort_d;

//	@Column(name = " D_RICHTIG ", nullable = false)
//	private boolean d_richtig;

	@ManyToOne
	@Autowired
	@JoinColumn(name = "TEST_ID")
	private Test test;
	
	/*
	 * Getter und Setter
	 */


	public String getFragenText() {
		return fragenText;
	}

	public void setFragenText(String fragenText) {
		this.fragenText = fragenText;
	}

	public String getAntwort_a() {
		return antwort_a;
	}

	public void setAntwort_a(String antwort_a) {
		this.antwort_a = antwort_a;
	}

	public String getAntwort_b() {
		return antwort_b;
	}

	public void setAntwort_b(String antwort_b) {
		this.antwort_b = antwort_b;
	}

	public String getAntwort_c() {
		return antwort_c;
	}

	public void setAntwort_c(String antwort_c) {
		this.antwort_c = antwort_c;
	}

	public String getAntwort_d() {
		return antwort_d;
	}

	public void setAntwort_d(String antwort_d) {
		this.antwort_d = antwort_d;
	}
	
		

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
