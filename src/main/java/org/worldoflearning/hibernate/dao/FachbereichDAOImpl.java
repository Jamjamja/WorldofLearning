package org.worldoflearning.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.FachbereichDAO;

@Repository("fachbereichDAO")
public class FachbereichDAOImpl implements FachbereichDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
}
