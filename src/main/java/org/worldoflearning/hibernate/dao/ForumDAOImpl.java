package org.worldoflearning.hibernate.dao;

import org.hibernate.SessionFactory;

public class ForumDAOImpl implements ForumDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
}
