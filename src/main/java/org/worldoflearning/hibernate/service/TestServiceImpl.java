package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.dao.TestDAO;

@Service("testService")
public class TestServiceImpl implements TestService {

	private TestDAO testDAO;
	
	public void setTestDAO(TestDAO testDAO){
		this.testDAO = testDAO;
	}
	
	@Override
	public void erstelleTest() {
		this.testDAO.erstelleTest();

	}

	@Override
	public void bearbeiteTest() {
		this.testDAO.bearbeiteTest();

	}

	@Override
	public void loescheTest() {
		this.testDAO.loescheTest();

	}

}
