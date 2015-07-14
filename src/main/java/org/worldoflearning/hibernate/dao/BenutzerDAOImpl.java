package org.worldoflearning.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.model.Benutzer;

@Repository("BenutzerDAO")
public class BenutzerDAOImpl implements BenutzerDAO {

	private static final Logger logger = LoggerFactory.getLogger(BenutzerDAOImpl.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void hinzufuegenBenutzer(Benutzer p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Benutzer saved successfully, Benutzer Details=" + p);
	}

	@Override
	public void updateBenutzer(Benutzer p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Benutzer updated successfully, Benutzer Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Benutzer> listBenutzer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Benutzer> BenutzersList = session.createQuery("from Benutzer").list();
		for (Benutzer p : BenutzersList) {
			logger.info("Benutzer List::" + p);
		}
		return BenutzersList;
	}

	@Override
	public Benutzer findeBenutzerNachId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Benutzer p = (Benutzer) session.load(Benutzer.class, new Integer(id));
		logger.info("Benutzer loaded successfully, Benutzer details=" + p);
		return p;
	}

	@Override
	public boolean findeBenutzerNachName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Benutzer p = (Benutzer) session.load(Benutzer.class, new String(name));
		if (p.getName() == name) {
			return true;
		}
		logger.info("Benutzer loaded successfully, Benutzer details=" + p);
		return false;
	}

	@Override
	public void loescheBenutzer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Benutzer p = (Benutzer) session.load(Benutzer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Benutzer deleted successfully, Benutzer details=" + p);
	}

}