package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.daointerface.ForumDAO;
import org.worldoflearning.hibernate.serviceinterface.ForumService;

@Service("forumService")
public class ForumServiceImpl implements ForumService {

	private ForumDAO forumDAO;
	
	public void setForumDAO(ForumDAO forumDAO){
		this.forumDAO = forumDAO;
		
	}
	
}
