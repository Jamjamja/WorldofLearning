package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.dao.ThemaDAO;
import org.worldoflearning.hibernate.model.Thema;

@Service("themaService")
public class ThemaServiceImpl implements ThemaService {

	private ThemaDAO themaDAO;
	
	public void setThemaDAO(ThemaDAO themaDAO){
		this.themaDAO = themaDAO;
	}
	
	@Override
	@Transactional
	public void bearbeiteThema() {
		this.themaDAO.bearbeiteThema();

	}

	@Override
	@Transactional
	public void loescheThema() {
		this.themaDAO.loescheThema();

	}

	@Override
	@Transactional
	public void sucheThema() {
		this.themaDAO.sucheThema();

	}

	@Override
	@Transactional
	public List<Thema> listThema() {
		this.themaDAO.sucheThema();
		return null;
	}

	@Override
	@Transactional
	public void erstelleThema(Thema thema) {
		this.themaDAO.erstelleThema(thema);
		
	}

}
