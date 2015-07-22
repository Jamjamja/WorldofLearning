package org.worldoflearning.hibernate.daointerface;

import org.worldoflearning.hibernate.model.Test;

public interface TestDAO {

	public void erstelleTest(Test test);

	public void bearbeiteTest(Test test);

	public void loescheTest(int test_id);

}
