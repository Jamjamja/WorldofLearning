package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.dao.BenutzerDAO;
import org.worldoflearning.hibernate.model.Benutzer;

@Service
public class BenutzerServiceImpl implements BenutzerService {
	
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
	public Benutzer findeBenutzerNachId(int id) {
		return this.benutzerDAO.findeBenutzerNachId(id);
	}
	
	@Override
	@Transactional
	public Benutzer findeBenutzerNachName(String benutzername) {
		return this.benutzerDAO.findeBenutzerNachName(benutzername);
	}

	@Override
	@Transactional
	public void loescheBenutzer(int id) {
		this.benutzerDAO.loescheBenutzer(id);
	}

}