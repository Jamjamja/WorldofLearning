package org.worldoflearning.hibernate.dao;

import java.util.List;

import org.worldoflearning.hibernate.model.Beitrag;

public interface BeitragDAO {

	public void erstelleBeitrag(Beitrag beitrag);

	public List<Beitrag> listBeitrag();
}
