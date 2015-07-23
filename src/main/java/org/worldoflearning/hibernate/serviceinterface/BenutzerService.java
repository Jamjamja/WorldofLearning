package org.worldoflearning.hibernate.serviceinterface;

import java.util.List;

import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.model.Gruppe;

public interface BenutzerService {

	public void hinzufuegenBenutzer(Benutzer benutzer);
	public void updateBenutzer(Benutzer benutzer);
	public List<Benutzer> listBenutzer();
	public void loescheBenutzer(String name);
	public Benutzer findeBenutzerNachName(String benutzername);
	public List<Benutzer> listBenutzer(Gruppe gruppe);
	public List<Benutzer> listBenutzer(Benutzer benutzer);
	public List<Benutzer> listnichtBenutzer(Benutzer benutzer);
}