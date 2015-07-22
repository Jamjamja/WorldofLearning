package org.worldoflearning.hibernate.serviceinterface;

import org.worldoflearning.hibernate.model.Frage;

public interface FrageService {

	public void erstelleFrage(Frage frage);

	public void loescheFrage(int id);

	public void bearbeiteFrage(Frage frage);
	
}
