package org.worldoflearning.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.worldoflearning.hibernate.daointerface.ChatbeitragDAO;
import org.worldoflearning.hibernate.model.Chatbeitrag;

@Repository("ChatbeitragDAO")
public class ChatbeitragDAOImpl implements ChatbeitragDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chatbeitrag> listChat() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Chatbeitrag.class);
		List<Chatbeitrag> listChat = (List<Chatbeitrag>) criteria.list();
		session.getTransaction().commit();
		return listChat;
	}

	@Override
	public void erstelleChatbeitrag(Chatbeitrag chatbeitrag) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(chatbeitrag);
		session.getTransaction().commit();
	}

}
