package org.worldoflearning.hibernate.service;

import java.util.List;

import org.worldoflearning.hibernate.model.Gruppe;

public interface GruppeService {

	public List<Gruppe> listGruppe();

	public void loescheGruppe(String gruppenname);

	public void hinzufuegenGruppe(Gruppe gruppe);

	public Gruppe findeGruppeNachName(String gruppename);

}
