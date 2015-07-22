package org.worldoflearning.hibernate.serviceinterface;

import java.util.List;

import org.worldoflearning.hibernate.model.Thema;

public interface ThemaService {

	public void erstelleThema(Thema thema);

	public void bearbeiteThema();

	public void loescheThema();

	public Thema findeThemanachID(int thema_id);

	public List<Thema> listThema();
	
}
