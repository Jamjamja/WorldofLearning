package org.worldoflearning.hibernate.daointerface;

public interface BadgeDAO {

	public void erhalteBadge();
	
	public boolean hatGenuegendPunkte(int benutzer_punkte);
	
}
