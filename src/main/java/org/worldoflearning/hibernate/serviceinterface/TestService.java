package org.worldoflearning.hibernate.serviceinterface;

import org.worldoflearning.hibernate.model.Test;

public interface TestService {

	public void erstelleTest(Test test);

	public void bearbeiteTest(Test test);
	
	public void loescheTest(int test_id);

	
}
