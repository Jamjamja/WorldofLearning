package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.dao.GruppeDAO;
import org.worldoflearning.hibernate.model.Gruppe;

@Service("gruppeService")
public class GruppeServiceImpl implements GruppeService {

	private GruppeDAO gruppeDAO;
	
	public void setGruppeDAO(GruppeDAO gruppeDAO){
		this.gruppeDAO = gruppeDAO;
	}

	@Override
	public Gruppe listGruppe() {
		return this.gruppeDAO.listGruppe();
	}

	@Override
	public void loescheGruppe(String gruppenname) {
		this.gruppeDAO.loescheGruppe(gruppenname);
		
	}

	@Override
	public void hinzufuegenGruppe(Gruppe gruppe) {
		this.gruppeDAO.hinzufuegenGruppe(gruppe);
		
	}

	@Override
	public Object findeGruppeNachName(String gruppename) {
		return this.gruppeDAO.findeGruppeNachName(gruppename);
	}
	
}
