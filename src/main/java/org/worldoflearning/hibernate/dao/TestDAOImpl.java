package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("testDAO")
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
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void bearbeiteTest() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void loescheTest() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

}
