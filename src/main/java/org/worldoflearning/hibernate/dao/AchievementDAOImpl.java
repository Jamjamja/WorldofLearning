package org.worldoflearning.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("achievementDAO")
public class AchievementDAOImpl implements AchievementDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void erhalteAchievement() {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hatGenuegendPunkte(int benutzer_punkte) {
		Session session = getSessionFactory().getCurrentSession();
		// TODO Auto-generated method stub
		return false;
	}

}
