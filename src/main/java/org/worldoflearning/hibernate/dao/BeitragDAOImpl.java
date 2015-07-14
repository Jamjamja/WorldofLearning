package org.worldoflearning.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.worldoflearning.hibernate.model.Beitrag;
import org.worldoflearning.hibernate.model.Chatbeitrag;

public class BeitragDAOImpl implements BeitragDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void loeschenBeitrag(Beitrag beitrag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(beitrag);
		session.getTransaction().commit();
	}

	@Override
	public void updateBeitrag(Beitrag beitrag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(beitrag);
		session.getTransaction().commit();
	}

	@Override
	public void updateInhalt(Beitrag beitrag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void erstelleBeitrag(Beitrag beitrag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(beitrag);
		session.getTransaction().commit();
	}

	@Override
	public Beitrag findeBeitragNachId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Beitrag> listBeitrag() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Beitrag.class);
		List<Beitrag> ListBeitrag = (List<Beitrag>)criteria.list();
		session.getTransaction().commit();
		return listBeitrag();
	}

}
