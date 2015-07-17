package org.worldoflearning.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.model.Thema;

@Repository("themaDAO")
public class ThemaDAOImpl implements ThemaDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void erstelleThema(Thema thema) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(thema);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Thema> listThema() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Thema.class);
		List<Thema> listThema = (List<Thema>) criteria.list();
		session.getTransaction().commit();
		return listThema;
	}

	@Override
	public void bearbeiteThema() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public void loescheThema() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public Thema findeThemanachID(int thema_id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Thema thema = (Thema) session.load(Thema.class, new Integer(thema_id));
		session.getTransaction().commit();
		return thema;
	}



}
