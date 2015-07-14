package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.GruppeDAO;

public class GruppeServiceImpl implements GruppeService {

	private GruppeDAO gruppeDAO;
	
	public void setGruppeDAO(GruppeDAO gruppeDAO){
		this.gruppeDAO = gruppeDAO;
	}
	
}
