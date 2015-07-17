package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.FrageDAO;
import org.worldoflearning.hibernate.model.Frage;

public class FrageServiceImpl implements FrageService {

	private FrageDAO frageDAO;
	
	public void setFrageDAO(FrageDAO frageDAO){
		this.frageDAO = frageDAO;
	}
	
	@Override
	public void erstelleFrage(Frage frage) {
		this.frageDAO.erstelleFrage(frage);

	}

	@Override
	public void bearbeiteFrage(Frage frage) {
		this.frageDAO.bearbeiteFrage(frage);

	}

	@Override
	public void loescheFrage(int id) {
		this.frageDAO.loescheFrage(id);

	}

}
