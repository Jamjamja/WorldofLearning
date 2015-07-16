package org.worldoflearning.hibernate.service;

import java.util.List;

import org.worldoflearning.hibernate.model.Beitrag;

public interface BeitragService {
	

	public void erstelleBeitrag(Beitrag beitrag);

	public List<Beitrag> listBeitrag();
}
