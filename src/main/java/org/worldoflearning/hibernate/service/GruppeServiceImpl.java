package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.dao.GruppeDAO;

@Service("gruppeService")
public class GruppeServiceImpl implements GruppeService {

	private GruppeDAO gruppeDAO;
	
	public void setGruppeDAO(GruppeDAO gruppeDAO){
		this.gruppeDAO = gruppeDAO;
	}
	
}
