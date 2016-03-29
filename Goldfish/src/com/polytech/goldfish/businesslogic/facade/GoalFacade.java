package com.polytech.goldfish.businesslogic.facade;

import java.sql.Date;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Goal;
import com.polytech.goldfish.businesslogic.manager.GoalManager;
import com.polytech.goldfish.util.GoldfishException;

/**
 * @author RedaM
 *
 */
public class GoalFacade {

	private static GoalManager goalManager;

	public GoalFacade(){
		GoalFacade.goalManager = new GoalManager();
	}

	public Integer createGoal(Integer idPerson, String name, String description, Date deadline) throws GoldfishException{
		return goalManager.createGoal(idPerson, name, description, deadline);
	}

	public Integer updateGoal(String newName, String newDescription, Date newDeadline) throws GoldfishException {
		return goalManager.updateGoal(newName, newDescription, newDeadline);
	}

	public Integer deleteGoal(Integer id) throws GoldfishException{
		return goalManager.deleteGoal(id);
	}

	public Collection<Goal> findAllGoals(){
		return goalManager.findAllGoals();
	}
}