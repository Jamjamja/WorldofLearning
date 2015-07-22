package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.QuestDAO;

@Repository("questDAO")
public class QuestDAOImpl implements QuestDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void erfuelleQuest(int anzahl_punkte, int benutzer_anzahl_punkte) {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

}
