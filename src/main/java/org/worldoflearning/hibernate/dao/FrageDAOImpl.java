package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.model.Frage;

public class FrageDAOImpl implements FrageDAO {

	private static final Logger logger = LoggerFactory.getLogger(BenutzerDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void erstelleFrage(Frage frage) {
//		Session session = getSessionFactory().getCurrentSession();
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(frage);
		logger.info("Frage wurde erfolgreich erstellt, Frage Details=" + frage);
		session.getTransaction().commit();

	}

	@Override
	public void bearbeiteFrage(Frage frage) {
//		Session session = getSessionFactory().getCurrentSession();
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(frage);
		logger.info("Frage wurde erfolgreich geändert, Frage Details=" + frage);
		session.getTransaction().commit();

	}

	@Override
	public void loescheFrage(int id) {
//		Session session = getSessionFactory().getCurrentSession();
		Session session = this.sessionFactory.getCurrentSession();
		Frage frage = (Frage) session.load(Frage.class, new Integer(id));
		if (null != frage) {
			session.delete(frage);
		}
		logger.info("Frage wurde erfolgreich gelöscht, Frage Details=" + frage);

	}

}
