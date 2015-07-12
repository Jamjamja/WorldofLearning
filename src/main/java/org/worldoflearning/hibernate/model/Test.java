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
 *  Die Methoden bis auf Getter und Setter müssen noch implementiert werden.
 */
@Entity
@Table(name = "Test", uniqueConstraints = { @UniqueConstraint(columnNames = { "TEST_ID" }) })
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEST_ID", nullable = false, unique = true, length = 11)
	private int test_id;

	@Column(name = "FRAGENANZAHL", nullable = false, unique = true, length = 11)
	private int fragenanzahl;

	@Column(name = "TEST_NAME", length = 20, nullable = true)
	private String test_name;

	@Column(name = " TEST_BEWERTUNG ", length = 20, nullable = true)
	private float test_bewertung;

	@Column(name = "TEST_ANZAHLBEWERTUNG", nullable = false, unique = true, length = 11)
	private int test_anzahlbewertung;

	/*
	 * Getter und Setter
	 */

	public int getFragenanzahl() {
		return fragenanzahl;
	}

	public void setFragenanzahl(int fragenanzahl) {
		this.fragenanzahl = fragenanzahl;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public float getTest_bewertung() {
		return test_bewertung;
	}

	public void setTest_bewertung(float test_bewertung) {
		this.test_bewertung = test_bewertung;
	}

	public int getTest_anzahlbewertung() {
		return test_anzahlbewertung;
	}

	public void setTest_anzahlbewertung(int test_anzahlbewertung) {
		this.test_anzahlbewertung = test_anzahlbewertung;
	}

	/*
	 * Methoden
	 */

	public void erstelleTest() {

	}

	public void bearbeiteTest() {

	}

	public void loescheTest() {

	}

}
