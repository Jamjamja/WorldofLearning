package org.worldoflearning.hibernate.dao;

import org.hibernate.SessionFactory;

public class FachbereichDAOImpl implements FachbereichDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
}
