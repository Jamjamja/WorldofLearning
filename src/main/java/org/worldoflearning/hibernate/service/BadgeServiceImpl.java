package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.BadgeDAO;

public class BadgeServiceImpl implements BadgeService {

	private BadgeDAO badgeDAO;
	
	public void setBadgeDAO(BadgeDAO badgeDAO){
		this.badgeDAO = badgeDAO;
	}
	
	@Override
	public void erhalteBadge() {
		this.badgeDAO.erhalteBadge();

	}

	@Override
	public boolean hatGenuegendPunkte(int benutzer_punkte) {
		return this.badgeDAO.hatGenuegendPunkte(benutzer_punkte);
	}

}
