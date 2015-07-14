package org.worldoflearning.hibernate.dao;

import java.util.List;

import org.worldoflearning.hibernate.model.Beitrag;

public interface BeitragDAO {

	public void loeschenBeitrag(Beitrag beitrag);

	public void updateBeitrag(Beitrag beitrag);

	public void updateInhalt(Beitrag beitrag);

	public void erstelleBeitrag(Beitrag beitrag);

	public Beitrag findeBeitragNachId(int id);

	public List<Beitrag> listBeitrag();
}
