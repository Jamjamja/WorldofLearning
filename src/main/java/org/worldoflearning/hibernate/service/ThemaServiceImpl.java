package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.ThemaDAO;

public class ThemaServiceImpl implements ThemaService {

	private ThemaDAO themaDAO;
	
	public void setThemaDAO(ThemaDAO themaDAO){
		this.themaDAO = themaDAO;
	}
	
	@Override
	public void erstelleThema() {
		this.themaDAO.erstelleThema();

	}

	@Override
	public void bearbeiteThema() {
		this.themaDAO.bearbeiteThema();

	}

	@Override
	public void loescheThema() {
		this.themaDAO.loescheThema();

	}

	@Override
	public void sucheThema() {
		this.themaDAO.sucheThema();

	}

}
