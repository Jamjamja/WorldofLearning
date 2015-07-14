package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.ModeratorDAO;

public class ModeratorServiceImpl implements ModeratorService {

	private ModeratorDAO moderatorDAO;
	
	public void setModeratorDAO(ModeratorDAO moderatorDAO){
		this.moderatorDAO = moderatorDAO;
	}
	
	@Override
	public void bearbeiteGruppe() {
		this.moderatorDAO.bearbeiteGruppe();

	}

	@Override
	public void loescheGruppe() {
		this.moderatorDAO.loescheGruppe();

	}

}
