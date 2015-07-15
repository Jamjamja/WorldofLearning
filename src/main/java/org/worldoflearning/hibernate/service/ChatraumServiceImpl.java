package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.dao.ChatraumDAO;

@Service("chatraumService")
public class ChatraumServiceImpl implements ChatraumService {

	private ChatraumDAO chatraumDAO;
	
	public void setChatramDAO(ChatraumDAO chatraumDAO){
		this.chatraumDAO = chatraumDAO;
	}
	
	@Override
	public void chatraumAlarm() {
		this.chatraumDAO.chatraumAlarm();

	}

	@Override
	public void erstelleChatraum() {
		this.chatraumDAO.erstelleChatraum();
	}

}
