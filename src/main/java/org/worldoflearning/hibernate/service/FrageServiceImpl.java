package org.worldoflearning.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.dao.FrageDAO;
import org.worldoflearning.hibernate.model.Frage;

@Service("frageService")
public class FrageServiceImpl implements FrageService {

	@Autowired
	private FrageDAO frageDAO;
	
	public void setFrageDAO(FrageDAO frageDAO){
		this.frageDAO = frageDAO;
	}
	
	@Override
	@Transactional
	public void erstelleFrage(Frage frage) {
		this.frageDAO.erstelleFrage(frage);

	}

	@Override
	@Transactional
	public void bearbeiteFrage(Frage frage) {
		this.frageDAO.bearbeiteFrage(frage);

	}

	@Override
	@Transactional
	public void loescheFrage(int id) {
		this.frageDAO.loescheFrage(id);

	}

}
