package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.worldoflearning.hibernate.daointerface.BadgeDAO;
import org.worldoflearning.hibernate.serviceinterface.BadgeService;

@Service("badgeService")
public class BadgeServiceImpl implements BadgeService {

	private BadgeDAO badgeDAO;
	
	public void setBadgeDAO(BadgeDAO badgeDAO){
		this.badgeDAO = badgeDAO;
	}
	
	@Override
	@Transactional
	public void erhalteBadge() {
		this.badgeDAO.erhalteBadge();

	}

	@Override
	@Transactional
	public boolean hatGenuegendPunkte(int benutzer_punkte) {
		return this.badgeDAO.hatGenuegendPunkte(benutzer_punkte);
	}

}
