package org.worldoflearning.hibernate.dao;

import org.hibernate.SessionFactory;

public class GruppeDAOImpl implements GruppeDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

}
