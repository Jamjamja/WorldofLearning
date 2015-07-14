package org.worldoflearning.hibernate.dao;

import org.hibernate.SessionFactory;

public class TestDAOImpl implements TestDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	@Override
	public void erstelleTest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bearbeiteTest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loescheTest() {
		// TODO Auto-generated method stub

	}

}
