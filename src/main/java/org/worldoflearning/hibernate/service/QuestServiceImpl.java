package org.worldoflearning.hibernate.service;

import org.springframework.stereotype.Service;
import org.worldoflearning.hibernate.daointerface.QuestDAO;
import org.worldoflearning.hibernate.serviceinterface.QuestService;

@Service("questService")
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
