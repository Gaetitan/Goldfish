package com.polytech.goldfish.persistence.factoryjdbc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Goal;
import com.polytech.goldfish.businesslogic.factory.GoalFactory;
import com.polytech.goldfish.persistence.jdbc.GoalJDBC;
import com.polytech.goldfish.util.GoldfishException;


/**
 * @author RedaM
 *
 */
public class GoalFactoryJDBC extends GoalFactory {

	@Override
	public Integer createGoal(Integer idPerson, String name, String description, Date deadline) {
		return GoalJDBC.createGoal(name, description, deadline);
	}

	@Override
	public Collection<Goal> getAllGoals() {
		// Creation of a collection of Diarys
		Collection<GoalJDBC> listGoalsJDBC = GoalJDBC.findAllGoals();
		Collection<Goal> listGoals = new ArrayList<Goal>();

		// Put the DiaryJDBC as Diary in a new list
		for(Goal goal : listGoalsJDBC) {
			listGoals.add(goal);
		}

		// Return the new list
		return listGoals;
	}

	@Override
	public Integer updateGoal(String newName, String newDescription, Date newDeadline) throws GoldfishException {
		return GoalJDBC.updateGoal(newName, newDescription, newDeadline);
	}

	@Override
	public Integer deleteGoal(Integer id) {
		return GoalJDBC.deleteGoal(id);
	}

}
