package org.worldoflearning.benutzer;

import java.sql.Date;
import java.util.*;

import org.worldoflearning.gruppenfkt.Gruppe;

public class Benutzer {

	private int id;
	private String nachname;
	private String vorname;
	private String passwort;
	private String email;
	private String benutzername;
	private Date letzerLogin;
	private Object profilbild;
	private List<Integer> gruppenZugehoerigkeit = new ArrayList<Integer>();
	private List<Integer> FreundesListe = new ArrayList<Integer>();

	public Benutzer(String nachname, String vorname, String passwort,
			String email, String benutzername) {
		super();
		this.nachname = nachname;
		this.vorname = vorname;
		this.passwort = passwort;
		this.email = email;
		this.benutzername = benutzername;
	}
	
	public void update() {
		
	}

	public void fuegeFreundHinzu(String benutzername) {
		int freundID;
		// tbd Datenbankzugriff
		freundID = 0;
		FreundesListe.add(freundID);
	}

	public void loescheFreund(String benutzername) {
		int freundID;
		// tbd Datenbankzugriff
		freundID = 0;
		FreundesListe.remove(freundID);
	}

	public void treteGruppeBei(String gruppenname, String gruppenpasswort) {
		int GruppenID;
		// tbd Datenbankzugriff
		GruppenID = 0;
		gruppenZugehoerigkeit.add(GruppenID);

	}

	public void verlasseGruppe(String gruppenname) {
		int GruppenID;
		// tbd Datenbankzugriff
		GruppenID = 0;
		gruppenZugehoerigkeit.remove(GruppenID);
	}

	public void erstelleGruppe(String gruppenname, String themengebiet) {
		Gruppe gruppe = new Gruppe();
		String gruppenpasswort;

		// tbd Datenbankzugriff
		gruppenpasswort = "";
		treteGruppeBei(gruppenname, gruppenpasswort);
	}

	/*
	 * Getter und Setter
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public Date getLetzerLogin() {
		return letzerLogin;
	}

	public void setLetzerLogin(Date letzerLogin) {
		this.letzerLogin = letzerLogin;
	}

	public Object getProfilbild() {
		return profilbild;
	}

	public void setProfilbild(Object profilbild) {
		this.profilbild = profilbild;
	}

}
