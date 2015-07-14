package org.worldoflearning.hibernate.dao;

import org.worldoflearning.hibernate.model.Frage;
import org.worldoflearning.hibernate.model.Test;

public interface TeamcombatDAO {

	public Frage stelleFrage(Test test);

	public void beantworteFrage();

	public void bekanntmachenErgebnisse();

	public void waehleTest(Test test);

	public void erhaltePunkte();

}
