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
@Table(name = "Frage", uniqueConstraints = { @UniqueConstraint(columnNames = { "TEAMCOMBAT_ID" }) })
public class Teamcombat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEAMCOMBAT_ID", nullable = false, unique = true, length = 11)
	private int teamcombat_id;
	
	@Column(name = "PUNKTE_GRUPPE_1", nullable = false, unique = true, length = 11)
	private int punkte_gruppe1;
	
	@Column(name = "PUNKTE_GRUPPE_2", nullable = false, unique = true, length = 11)
	private int punkte_gruppe2;
	
	@Column(name = "TEILNEHMER_GRUPPE_1", length = 40, nullable = true)
	private String teilnehmer_gruppe1;
	
	@Column(name = "TEILNEHMER_GRUPPE_2", length = 40, nullable = true)
	private String teilnehmer_gruppe2;
	
	@Column(name = "VERWENDETER_TEST_GRUPPE_1", nullable = true)
	private Test verwendeter_test_gruppe1;
	
	@Column(name = "VERWENDETER_TEST_GRUPPE_2", nullable = true)
	private Test verwendeter_test_gruppe2;
	
	/*
	 * Getter und Setter 
	 */
	
	public int getPunkte_gruppe1() {
		return punkte_gruppe1;
	}
	public void setPunkte_gruppe1(int punkte_gruppe1) {
		this.punkte_gruppe1 = punkte_gruppe1;
	}
	public int getPunkte_gruppe2() {
		return punkte_gruppe2;
	}
	public void setPunkte_gruppe2(int punkte_gruppe2) {
		this.punkte_gruppe2 = punkte_gruppe2;
	}
	public int getTeamcombat_id() {
		return teamcombat_id;
	}
	public void setTeamcombat_id(int teamcombat_id) {
		this.teamcombat_id = teamcombat_id;
	}
	public String getTeilnehmer_gruppe1() {
		return teilnehmer_gruppe1;
	}
	public void setTeilnehmer_gruppe1(String teilnehmer_gruppe1) {
		this.teilnehmer_gruppe1 = teilnehmer_gruppe1;
	}
	public String getTeilnehmer_gruppe2() {
		return teilnehmer_gruppe2;
	}
	public void setTeilnehmer_gruppe2(String teilnehmer_gruppe2) {
		this.teilnehmer_gruppe2 = teilnehmer_gruppe2;
	}
	public Test getVerwendeter_test_gruppe1() {
		return verwendeter_test_gruppe1;
	}
	public void setVerwendeter_test_gruppe1(Test verwendeter_test_gruppe1) {
		this.verwendeter_test_gruppe1 = verwendeter_test_gruppe1;
	}
	public Test getVerwendeter_test_gruppe2() {
		return verwendeter_test_gruppe2;
	}
	public void setVerwendeter_test_gruppe2(Test verwendeter_test_gruppe2) {
		this.verwendeter_test_gruppe2 = verwendeter_test_gruppe2;
	}

	/*
	 * Methoden
	 */
	
//	public Frage stelleFrage(Test test){
//		
//		return;
//	}
	
	public void beantworteFrage(){
		
	}
	
	public void bekanntmachenErgebnisse(){
		
	}
	
	public void waehleTest (Test test){
		
	}
	
	public void erhaltePunkte(){
		
	}
}
