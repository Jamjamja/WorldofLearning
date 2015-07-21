package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.model.Gruppe;

public interface GruppeService {

	public Gruppe listGruppe();

	public void loescheGruppe(String gruppenname);

	public void hinzufuegenGruppe(Gruppe gruppe);

	public Gruppe findeGruppeNachName(String gruppename);

}
