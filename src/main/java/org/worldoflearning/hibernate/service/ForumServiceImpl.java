package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.ForumDAO;

public class ForumServiceImpl implements ForumService {

	private ForumDAO forumDAO;
	
	public void setForumDAO(ForumDAO forumDAO){
		this.forumDAO = forumDAO;
		
	}
	
}
