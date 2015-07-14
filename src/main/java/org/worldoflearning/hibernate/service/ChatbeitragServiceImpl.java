package org.worldoflearning.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.dao.ChatbeitragDAO;
import org.worldoflearning.hibernate.model.Chatbeitrag;

@Service
public class ChatbeitragServiceImpl implements ChatbeitragService {

	private ChatbeitragDAO chatbeitragDAO;

	public void setChatbeitragDAO(ChatbeitragDAO chatbeitragDAO) {
		this.chatbeitragDAO = chatbeitragDAO;
	}

	@Override
	@Transactional
	public List<Chatbeitrag> listChat() {
		return this.chatbeitragDAO.listChat();
	}

	@Override
	@Transactional
	public void erstelleChatbeitrag(Chatbeitrag chatbeitrag) {
		this.chatbeitragDAO.erstelleChatbeitrag(chatbeitrag);
	}
	
}
