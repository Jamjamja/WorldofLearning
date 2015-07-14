package org.worldoflearning.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.model.Benutzer;

@Repository("BenutzerDAO")
public class BenutzerDAOImpl implements BenutzerDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(BenutzerDAOImpl.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	@Override
	public void hinzufuegenBenutzer(Benutzer benutzer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(benutzer);
		logger.info("Benutzer saved successfully, Benutzer Details=" + benutzer);
		session.getTransaction().commit();
	}

	@Override
	public void updateBenutzer(Benutzer benutzer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(benutzer);
		logger.info("Benutzer updated successfully, Benutzer Details=" + benutzer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Benutzer> listBenutzer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Benutzer> BenutzersList = session.createQuery("from Benutzer")
				.list();
		for (Benutzer benutzer : BenutzersList) {
			logger.info("Benutzer List::" + benutzer);
		}
		return BenutzersList;
	}

	@Override
	public Benutzer findeBenutzerNachId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Benutzer benutzer = (Benutzer) session.load(Benutzer.class, new Integer(id));
		logger.info("Benutzer loaded successfully, Benutzer details=" + benutzer);
		return benutzer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Benutzer findeBenutzerNachName(String benutzername) {
	 
			List<Benutzer> benutzerlist = new ArrayList<Benutzer>();
	 
			benutzerlist = sessionFactory.getCurrentSession()
				.createQuery("from Benutzer where benutzername=?")
				.setParameter(0, benutzername)
				.list();
	 
			if (benutzerlist.size() > 0) {
				return benutzerlist.get(0);
			} else {
				return null;
			}
	 
		}
	
	@Override
	public void loescheBenutzer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Benutzer benutzer = (Benutzer) session.load(Benutzer.class, new Integer(id));
		if (null != benutzer) {
			session.delete(benutzer);
		}
		logger.info("Benutzer deleted successfully, Benutzer details=" + benutzer);
	}

	@Override
	public boolean findeBenutzerNachEMail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Benutzer benutzer = (Benutzer) session.load(Benutzer.class, new String(email));
		if (benutzer.getEmail() == email){
			return true;			
		}
		logger.info("Benutzer loaded successfully, Benutzer details=" + benutzer);
		return false;
	}

}