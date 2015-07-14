package org.worldoflearning.hibernate.service;

import org.worldoflearning.hibernate.dao.QuestDAO;

public class QuestServiceImpl implements QuestService {

	private QuestDAO questDAO;
	
	public void setQuestDAO(QuestDAO questDAO){
		this.questDAO = questDAO;
	}
	
	@Override
	public void erfuelleQuest(int anzahl_punkte, int benutzer_anzahl_punkte) {
		this.questDAO.erfuelleQuest(anzahl_punkte, benutzer_anzahl_punkte);

	}

}
