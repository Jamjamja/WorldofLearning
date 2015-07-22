package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.daointerface.BenutzerDAO;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.serviceinterface.BenutzerService;

@Service("benutzerService")
public class BenutzerServiceImpl implements BenutzerService {
	
	@Autowired
	private BenutzerDAO benutzerDAO;

	public void setBenutzerDAO(BenutzerDAO benutzerDAO) {
		this.benutzerDAO = benutzerDAO;
	}
	
	@Override
	@Transactional
	public void hinzufuegenBenutzer(Benutzer benutzer) {
		this.benutzerDAO.hinzufuegenBenutzer(benutzer);
	}

	@Override
	@Transactional
	public void updateBenutzer(Benutzer benutzer) {
		this.benutzerDAO.updateBenutzer(benutzer);
	}

	@Override
	@Transactional
	public List<Benutzer> listBenutzer() {
		return this.benutzerDAO.listBenutzer();
	}
	
	@Override
	@Transactional
	public Benutzer findeBenutzerNachName(String benutzername) {
		return this.benutzerDAO.findeBenutzerNachName(benutzername);
	}

	@Override
	@Transactional
	public void loescheBenutzer(String benutzername) {
		this.benutzerDAO.loescheBenutzer(benutzername);
	}
	

	
}