package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.daointerface.BeitragDAO;
import org.worldoflearning.hibernate.model.Beitrag;
import org.worldoflearning.hibernate.model.Thema;
import org.worldoflearning.hibernate.serviceinterface.BeitragService;

@Service("beitragService")
public class BeitragServiceImpl implements BeitragService {

	private BeitragDAO beitragDAO;
	
	public void setBeitragDAO(BeitragDAO beitragDAO) {
		this.beitragDAO = beitragDAO;
	}

	@Override
	@Transactional
	public List<Beitrag> listBeitrag(Thema thema) {
		return this.beitragDAO.listBeitrag(thema);
	}

	@Override
	@Transactional
	public void erstelleBeitrag(Beitrag beitrag) {
		this.beitragDAO.erstelleBeitrag(beitrag);
	}
}
