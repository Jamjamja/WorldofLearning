package org.worldoflearning.hibernate.service;

import java.util.List;

import org.worldoflearning.hibernate.model.Benutzer;

public interface BenutzerService {

	public void hinzufuegenBenutzer(Benutzer benutzer);
	public void updateBenutzer(Benutzer benutzer);
	public List<Benutzer> listBenutzer();
	public Benutzer findeBenutzerNachId(int id);
	public void loescheBenutzer(int id);
	public Benutzer findeBenutzerNachName(String benutzername);
	
}