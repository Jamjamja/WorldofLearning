package org.worldoflearning.hibernate.daointerface;

import java.util.List;

import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.model.Gruppe;

public interface BenutzerDAO {

	public void hinzufuegenBenutzer(Benutzer benutzer);

	public void updateBenutzer(Benutzer benutzer);

	public List<Benutzer> listBenutzer();

	public void loescheBenutzer(String name);

	public Benutzer findeBenutzerNachName(String benutzername);
	
	public boolean findeBenutzerNachEMail(String email);
	
	public List<Benutzer> listBenutzer(Gruppe gruppe);
}
	