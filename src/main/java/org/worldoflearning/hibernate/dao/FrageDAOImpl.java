package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.FrageDAO;
import org.worldoflearning.hibernate.model.Frage;

@Repository("frageDAO")
public class FrageDAOImpl implements FrageDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void erstelleFrage(Frage frage) {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void bearbeiteFrage(Frage frage) {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void loescheFrage(int id) {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

}
