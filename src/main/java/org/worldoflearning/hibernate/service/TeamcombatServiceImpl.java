package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.dao.TeamcombatDAO;
import org.worldoflearning.hibernate.model.Frage;
import org.worldoflearning.hibernate.model.Test;

@Service("teamcombatService")
public class TeamcombatServiceImpl implements TeamcombatService {

	private TeamcombatDAO teamcombatDAO;
	
	public void setTeamcombatDAO(TeamcombatDAO teamcombatDAO){
		this.teamcombatDAO = teamcombatDAO;
	}
	
	@Override
	public Frage stelleFrage(Test test) {
		return this.teamcombatDAO.stelleFrage(test);
	}

	@Override
	public void beantworteFrage() {
		this.teamcombatDAO.beantworteFrage();

	}

	@Override
	public void bekanntmachenErgebnisse() {
		this.teamcombatDAO.bekanntmachenErgebnisse();

	}

	@Override
	public void waehleTest(Test test) {
		this.teamcombatDAO.waehleTest(test);

	}

	@Override
	public void erhaltePunkte() {
		this.teamcombatDAO.erhaltePunkte();

	}

}
