package org.worldoflearning.hibernate.dao;

import org.worldoflearning.hibernate.model.Gruppe;

public interface GruppeDAO {

	public Gruppe listGruppe();

	public void loescheGruppe(String gruppenname);

	public void hinzufuegenGruppe(Gruppe gruppe);

	public Gruppe findeGruppeNachName(String gruppename);

}
