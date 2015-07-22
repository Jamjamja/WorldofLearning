package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.daointerface.GruppeDAO;
import org.worldoflearning.hibernate.model.Gruppe;
import org.worldoflearning.hibernate.serviceinterface.GruppeService;

@Service("gruppeService")
public class GruppeServiceImpl implements GruppeService {

	private GruppeDAO gruppeDAO;
	
	public void setGruppeDAO(GruppeDAO gruppeDAO){
		this.gruppeDAO = gruppeDAO;
	}

	@Override
	public List<Gruppe> listGruppe() {
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
	public Gruppe findeGruppeNachName(String gruppename) {
		return this.gruppeDAO.findeGruppeNachName(gruppename);
	}
	
}
