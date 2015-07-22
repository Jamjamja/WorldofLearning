package org.worldoflearning.hibernate.serviceinterface;

import java.util.List;

import org.worldoflearning.hibernate.model.Beitrag;
import org.worldoflearning.hibernate.model.Thema;

public interface BeitragService {
	

	public void erstelleBeitrag(Beitrag beitrag);

	public List<Beitrag> listBeitrag(Thema thema);
}
