package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.ModeratorDAO;

@Repository("moderatorDAO")
public class ModeratorDAOImpl implements ModeratorDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void bearbeiteGruppe() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void loescheGruppe() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

}
