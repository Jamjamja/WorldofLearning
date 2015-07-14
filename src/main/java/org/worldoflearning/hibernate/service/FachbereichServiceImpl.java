package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.FachbereichDAO;

public class FachbereichServiceImpl implements FachbereichService {

	private FachbereichDAO fachbereichDAO;
	
	public void setFachbereichDAO(FachbereichDAO fachbereichDAO){
		this.fachbereichDAO = fachbereichDAO;
	}
		
}
