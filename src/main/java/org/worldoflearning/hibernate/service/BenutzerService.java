package org.worldoflearning.hibernate.service;

import java.util.List;

import org.worldoflearning.hibernate.model.Benutzer;

public interface BenutzerService {

	public void hinzufuegenBenutzer(Benutzer b);
	
	public void updateBenutzer(Benutzer b);
	
	public List<Benutzer> listBenutzer();
	
	public Benutzer findeBenutzerNachId(int id);
	
	public void loescheBenutzer(int id);
	
	public boolean findeBenutzerNachName(String name);
	
}