package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.FrageDAO;

public class FrageServiceImpl implements FrageService {

	private FrageDAO frageDAO;
	
	public void setFrageDAO(FrageDAO frageDAO){
		this.frageDAO = frageDAO;
	}
	
	@Override
	public void erstelleFrage() {
		this.frageDAO.erstelleFrage();

	}

	@Override
	public void bearbeiteFrage() {
		this.frageDAO.bearbeiteFrage();

	}

	@Override
	public void loescheFrage() {
		this.frageDAO.loescheFrage();

	}

}
