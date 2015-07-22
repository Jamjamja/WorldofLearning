package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.daointerface.ModeratorDAO;
import org.worldoflearning.hibernate.serviceinterface.ModeratorService;

@Service("moderatorService")
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
