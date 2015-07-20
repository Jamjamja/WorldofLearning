package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.model.Test;

public interface TestService {

	public void erstelleTest(Test test);

	public void bearbeiteTest(Test test);

	public void loescheTest(int test_id);
	
	public void findeTest(String name);
	
}
