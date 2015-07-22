package org.worldoflearning.hibernate.daointerface;

import java.util.List;

import org.worldoflearning.hibernate.model.Beitrag;
import org.worldoflearning.hibernate.model.Thema;

public interface BeitragDAO {

	public void erstelleBeitrag(Beitrag beitrag);

	public List<Beitrag> listBeitrag(Thema thema);
}
