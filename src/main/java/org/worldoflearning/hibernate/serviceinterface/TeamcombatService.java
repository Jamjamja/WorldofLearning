package org.worldoflearning.hibernate.serviceinterface;

import org.worldoflearning.hibernate.model.Frage;
import org.worldoflearning.hibernate.model.Test;

public interface TeamcombatService {

	public Frage stelleFrage(Test test);

	public void beantworteFrage();

	public void bekanntmachenErgebnisse();

	public void waehleTest(Test test);

	public void erhaltePunkte();
	
}
