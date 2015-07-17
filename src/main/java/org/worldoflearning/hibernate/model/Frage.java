package org.worldoflearning.hibernate.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 *  Die Methoden bis auf Getter und Setter müssen noch implementiert werden.
 */
@Entity
@Table(name = "Frage", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Frage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = " FRAGENTEXT ", length = 255, nullable = false)
	private String fragenText;
	
//	@Column(name = " KATEGORIE ", length = 100, nullable = false)
//	private String kategorie;
//
//	@Column(name = " BEWERTUNG ", length = 5, nullable = true)
//	private float bewertung;
//
//	@Column(name = " ANZAHLBEWERTUNGEN ", nullable = false, unique = true, length = 11)
//	private int anzahlBewertungen;

	
	@Column(name = " ANTWORT_A", length = 255, nullable = false)
	private String antwort_a;

//	@Column(name = " A_RICHTIG ", nullable = false)
//	private boolean a_richtig;
	
	
	@Column(name = " ANTWORT_B", length = 255, nullable = false)
	private String antwort_b;

//	@Column(name = " B_RICHTIG ", nullable = false)
//	private boolean b_richtig;

	
	@Column(name = " ANTWORT_C", length = 255, nullable = false)
	private String antwort_c;

//	@Column(name = " C_RICHTIG ", nullable = false)
//	private boolean c_richtig;
	
	
	@Column(name = " ANTWORT_D", length = 255, nullable = false)
	private String antwort_d;

//	@Column(name = " D_RICHTIG ", nullable = false)
//	private boolean d_richtig;

	/*
	 * Getter und Setter
	 */

	
	
	
//	@ManyToOne
//	@JoinColumn(name = "TEST_ID")
//	private Test test_id;
	
}
