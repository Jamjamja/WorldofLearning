package org.worldoflearning.gruppenfkt;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Gruppe {

	private int id;
	private String gruppenname;
	private Date erstelldatum;
	private String themengebiet;
	// Durchschnittsnote, die die Gruppe aufgrund der Bewertungen erhalten hat.
	private double bewertung;
	// Anzahl Bewertungen, die diese Gruppe erhalten hat
	private int anzahlBewertungen;
	// Beschreibung der Gruppe nach aussen, damit Aussenstehende den Zweck der
	// Gruppe kennen
	private String beschreibung;
	// Punkte durch Teamcombats - Wie Gruppe Punkte erhält, noch überarbeiten
	private int gruppenpunkte;

	private List<Integer> gruppenMitglieder = new ArrayList<Integer>();

	// enthält die id's aller Gruppen, gegen die gerade Combats offen sind
	private List<Integer> aktuelleGruppenCombats = new ArrayList<Integer>();

	
	public Gruppe(String gruppenname, String themengebiet, String beschreibung) {
		super();
		this.gruppenname = gruppenname;
		this.themengebiet = themengebiet;
		this.beschreibung = beschreibung;
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

	public String getGruppenname() {
		return gruppenname;
	}

	public void setGruppenname(String gruppenname) {
		this.gruppenname = gruppenname;
	}

	public Date getErstelldatum() {
		return erstelldatum;
	}

	public void setErstelldatum(Date erstelldatum) {
		this.erstelldatum = erstelldatum;
	}

	public String getThemengebiet() {
		return themengebiet;
	}

	public void setThemengebiet(String themengebiet) {
		this.themengebiet = themengebiet;
	}

	public double getBewertung() {
		return bewertung;
	}

	public void setBewertung(double bewertung) {
		this.bewertung = bewertung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	/*
	 * Methoden
	 */

	public void fuegeMitgliedHinzu(int BenuterID) {
		gruppenMitglieder.add(BenuterID);
	}

	public void loescheMitglied(int BenuterID) {
		gruppenMitglieder.remove(BenuterID);
	}

	public void verrechnePunkte(int punkte) { // punkte sind hier das Ergebnis
												// eines Teamcobats, koennen
												// also negativ (Niederlage)
												// oder positiv (Sieg)
												// sein
	gruppenpunkte += punkte;
		// tbd Datenbankzugriff

	}

	public void fordereGruppeHeraus(int gruppenID) {
		// tbd sende eine Nachricht(enthaelt id dieser Gruppe) ueber
		// Herausforderung an eine andere Gruppe.
		// tbd DB-Zugriff

	}

	public void nehmeHerausforderungAn(int gruppenID) {
		aktuelleGruppenCombats.add(gruppenID);
		// tbd fuege zu aktuelleGruppenCombats der anderen Gruppe die id dieser
	}
}
