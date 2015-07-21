package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.dao.TestDAO;
import org.worldoflearning.hibernate.model.Test;

@Service("testService")
public class TestServiceImpl implements TestService {

	private TestDAO testDAO;
	
	public void setTestDAO(TestDAO testDAO){
		this.testDAO = testDAO;
	}
	
	@Override
	@Transactional
	public void erstelleTest(Test test) {
		this.testDAO.erstelleTest(test);

	}

	@Override
	@Transactional
	public void bearbeiteTest(Test test) {
		this.testDAO.bearbeiteTest(test);

	}

	@Override
	@Transactional
	public void loescheTest(int test_id) {
		this.testDAO.loescheTest(test_id);

	}

}
