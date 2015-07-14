package org.worldoflearning.hibernate.dao;

import org.hibernate.SessionFactory;
import org.worldoflearning.hibernate.model.Frage;
import org.worldoflearning.hibernate.model.Test;

public class TeamcombatDAOImpl implements TeamcombatDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	
	@Override
	public Frage stelleFrage(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beantworteFrage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bekanntmachenErgebnisse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void waehleTest(Test test) {
		// TODO Auto-generated method stub

	}

	@Override
	public void erhaltePunkte() {
		// TODO Auto-generated method stub

	}

}
