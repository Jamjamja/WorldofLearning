package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.TestDAO;
import org.worldoflearning.hibernate.model.Frage;
import org.worldoflearning.hibernate.model.Test;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO {

	private static final Logger logger = LoggerFactory.getLogger(BenutzerDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void erstelleTest(Test test) {
//		Session session = getSessionFactory().getCurrentSession();
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(test);
		logger.info("Test wurde erfolgreich erstellt, Test Details=" + test);
		session.getTransaction().commit();
	}

	@Override
	public void bearbeiteTest(Test test) {
//		Session session = getSessionFactory().getCurrentSession();
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(test);
		logger.info("Test wurde erfolgreich bearbeitet, Test Details=" + test);
		session.getTransaction().commit();

	}

	@Override
	public void loescheTest(int test_id) {
//		Session session = getSessionFactory().getCurrentSession();
		Session session = this.sessionFactory.getCurrentSession();
		Test test = (Test) session.load(Test.class, new Integer(test_id));
		if (null != test) {
			session.delete(test);
		}
		session.getTransaction().commit();
		logger.info("Test wurde erfolgreich gelöscht, Test Details=" + test);


	}

}
