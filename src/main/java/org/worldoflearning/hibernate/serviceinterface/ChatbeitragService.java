package org.worldoflearning.hibernate.serviceinterface;

import java.util.List;

import org.worldoflearning.hibernate.model.Chatbeitrag;

public interface ChatbeitragService {
	public List<Chatbeitrag> listChat();
	public void erstelleChatbeitrag(Chatbeitrag chatbeitrag);
}
	