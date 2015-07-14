package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.dao.BeitragDAO;
import org.worldoflearning.hibernate.model.Beitrag;

public class BeitragServiceImpl implements BeitragService {

	private BeitragDAO beitragDAO;
	
	public void setBeitragDAO(BeitragDAO beitragDAO) {
		this.beitragDAO = beitragDAO;
	}

	@Override
	@Transactional
	public List<Beitrag> listBeitrag() {
		return this.beitragDAO.listBeitrag();
	}

	@Override
	@Transactional
	public void erstelleBeitrag(Beitrag beitrag) {
		this.beitragDAO.erstelleBeitrag(beitrag);
	}

	@Override
	public void loeschenBeitrag(Beitrag beitrag) {
		this.beitragDAO.loeschenBeitrag(beitrag);

	}

	@Override
	public void updateBeitrag(Beitrag beitrag) {
		this.beitragDAO.loeschenBeitrag(beitrag);
	}

	@Override
	public void updateInhalt(Beitrag beitrag) {
		this.beitragDAO.loeschenBeitrag(beitrag);

	}

	@Override
	public Beitrag findeBeitragNachId(int id) {
		return this.beitragDAO.findeBeitragNachId(id);
	}
	

}
