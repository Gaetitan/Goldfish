package com.polytech.goldfish.businesslogic.factory;

import java.sql.Date;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Goal;
import com.polytech.goldfish.util.GoldfishException;



/**
 * @author RedaM
 *
 */
public abstract class GoalFactory {

	public abstract Integer updateGoal(String newName, String newDescription, Date newDeadline) throws GoldfishException;

	public abstract Collection<Goal> getAllGoals();

	public abstract Integer createGoal(Integer idPerson, String name, String description, Date deadline);

	public abstract Integer deleteGoal(Integer id);

}