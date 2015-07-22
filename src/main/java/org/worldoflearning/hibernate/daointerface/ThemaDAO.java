package org.worldoflearning.hibernate.daointerface;

import java.util.List;

import org.worldoflearning.hibernate.model.Thema;

public interface ThemaDAO {

	public void erstelleThema(Thema thema);

	public List<Thema> listThema();

	public void bearbeiteThema();

	public void loescheThema();

	public Thema findeThemanachID(int thema_id);

}
