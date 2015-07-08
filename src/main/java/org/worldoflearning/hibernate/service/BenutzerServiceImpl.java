package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public void hinzufuegenBenutzer(Benutzer b) {
		this.benutzerDAO.hinzufuegenBenutzer(b);
	}

	@Override
	@Transactional
	public void updateBenutzer(Benutzer b) {
		this.benutzerDAO.updateBenutzer(b);
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
	public boolean findeBenutzerNachName(String name) {
		return this.benutzerDAO.findeBenutzerNachName(name);
	}

	@Override
	@Transactional
	public void loescheBenutzer(int id) {
		this.benutzerDAO.loescheBenutzer(id);
	}

}
