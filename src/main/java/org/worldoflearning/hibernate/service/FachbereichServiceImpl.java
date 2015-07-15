package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.dao.FachbereichDAO;

@Service("fachbereichService")
public class FachbereichServiceImpl implements FachbereichService {

	private FachbereichDAO fachbereichDAO;
	
	public void setFachbereichDAO(FachbereichDAO fachbereichDAO){
		this.fachbereichDAO = fachbereichDAO;
	}
		
}
