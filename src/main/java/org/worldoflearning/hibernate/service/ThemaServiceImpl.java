package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.daointerface.ThemaDAO;
import org.worldoflearning.hibernate.model.Thema;
import org.worldoflearning.hibernate.serviceinterface.ThemaService;

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
	public Thema findeThemanachID(int thema_id) {
		return this.themaDAO.findeThemanachID(thema_id);

	}

	@Override
	@Transactional
	public List<Thema> listThema() {
		return this.themaDAO.listThema();
	}

	@Override
	@Transactional
	public void erstelleThema(Thema thema) {
		this.themaDAO.erstelleThema(thema);
		
	}

}
