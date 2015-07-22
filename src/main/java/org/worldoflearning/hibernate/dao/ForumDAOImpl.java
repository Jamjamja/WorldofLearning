package org.worldoflearning.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.ForumDAO;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
}
