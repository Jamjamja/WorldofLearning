package org.worldoflearning.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.model.Gruppe;


@Repository("gruppeDAO")
public class GruppeDAOImpl implements GruppeDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gruppe> listGruppe() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Gruppe.class);
		List<Gruppe> listGruppe = (List<Gruppe>) criteria.list();
		session.clear();
		return listGruppe;
	}

	@Override
	public void loescheGruppe(String gruppenname) {
		Session session = this.sessionFactory.getCurrentSession();
		Gruppe gruppe = (Gruppe) session.load(Gruppe.class, new String(
				gruppenname));
		if (null != gruppenname) {
			session.delete(gruppe);
		}
//		logger.info("Benutzer deleted successfully, Benutzer details="
//				+ gruppe);
	}

	@Override
	public void hinzufuegenGruppe(Gruppe gruppe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(gruppe);
//		logger.info("Benutzer saved successfully, Benutzer Details=" + gruppe);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Gruppe findeGruppeNachName(String gruppenname) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Gruppe> gruppenlist = new ArrayList<Gruppe>();
		session.beginTransaction();
		gruppenlist = sessionFactory.getCurrentSession()
				.createQuery("from Gruppe where gruppenname=?")
				.setParameter(0, gruppenname).list();
		session.close();
		if (gruppenlist.size() > 0) {
			return gruppenlist.get(0);
		} else {
			return null;
		}
	}

}
