package org.worldoflearning.hibernate.service;

import java.util.List;

import org.worldoflearning.hibernate.model.Chatbeitrag;

public interface ChatbeitragService {
	public List<Chatbeitrag> listChat();
	public void erstelleChatbeitrag(Chatbeitrag chatbeitrag);
}
	