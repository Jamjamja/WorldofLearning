package org.worldoflearning.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.BeitragDAO;
import org.worldoflearning.hibernate.model.Beitrag;
import org.worldoflearning.hibernate.model.Thema;

@Repository("beitragDAO")
public class BeitragDAOImpl implements BeitragDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}


	@Override
	public void erstelleBeitrag(Beitrag beitrag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(beitrag);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Beitrag> listBeitrag(Thema thema) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Beitrag.class).add( Restrictions.like("thema", thema) );
		List<Beitrag> listBeitrag = (List<Beitrag>)criteria.list();
		session.getTransaction().commit();
		return listBeitrag;
	}

}
