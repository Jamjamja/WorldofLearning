package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
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
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void beantworteFrage() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void bekanntmachenErgebnisse() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void waehleTest(Test test) {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void erhaltePunkte() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

}
