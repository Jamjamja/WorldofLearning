package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.daointerface.AchievementDAO;
import org.worldoflearning.hibernate.serviceinterface.AchievementService;

@Service("achievementService")
public class AchievementServiceImpl implements AchievementService {

	private AchievementDAO achievementDAO;

	public void setAchievementDAO(AchievementDAO achievementDAO) {
		this.achievementDAO = achievementDAO;
	}

	@Override
	public void erhalteAchievement() {
		this.achievementDAO.erhalteAchievement();
	}

	@Override
	public boolean hatGenuegendPunkte(int benutzer_punkte) {
		return this.achievementDAO.hatGenuegendPunkte(benutzer_punkte);
	}

}
