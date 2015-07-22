package org.worldoflearning.hibernate.daointerface;

import org.worldoflearning.hibernate.model.Frage;

public interface FrageDAO {

	public void erstelleFrage(Frage frage);

	public void bearbeiteFrage(Frage frage);

	public void loescheFrage(int id);

}
