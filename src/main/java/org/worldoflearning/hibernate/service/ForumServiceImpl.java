package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.dao.ForumDAO;

@Service("forumService")
public class ForumServiceImpl implements ForumService {

	private ForumDAO forumDAO;
	
	public void setForumDAO(ForumDAO forumDAO){
		this.forumDAO = forumDAO;
		
	}
	
}
