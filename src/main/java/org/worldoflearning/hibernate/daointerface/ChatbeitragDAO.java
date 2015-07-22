package org.worldoflearning.hibernate.daointerface;

import java.util.List;

import org.worldoflearning.hibernate.model.Chatbeitrag;

public interface ChatbeitragDAO {

	public List<Chatbeitrag> listChat();

	public void erstelleChatbeitrag(Chatbeitrag chatbeitrag);

}
