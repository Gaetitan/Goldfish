package com.polytech.goldfish.businesslogic.manager;

import java.sql.Date;
import java.util.Collection;

import com.polytech.goldfish.businesslogic.business.Goal;
import com.polytech.goldfish.businesslogic.factory.GoalFactory;
import com.polytech.goldfish.persistence.factoryjdbc.GoalFactoryJDBC;
import com.polytech.goldfish.util.GoldfishException;





/**
 * @author RedaM
 *
 */
public class GoalManager {

	private final GoalFactory factory;
	private PersonManager person;

	public GoalManager(){
		this.factory = new GoalFactoryJDBC();
	}

	public Integer createGoal(Integer idPerson, String name, String description, Date deadline) throws GoldfishException {
		if(name.isEmpty() || name == "" || description.isEmpty() || description == ""){
			throw new GoldfishException("Goal name nor description can be empty.");
		}
		else{
			return this.factory.createGoal(idPerson, name, description, deadline);	
		}
	}

	public Integer updateGoal(String newName, String newDescription, Date newDeadline) throws GoldfishException{
		if(newName.isEmpty() || newName == "" || newDescription.isEmpty() || newDescription == ""){
			throw new GoldfishException("Goal name nor description can be empty.");
		}
		else{
			return this.factory.updateGoal(newName, newDescription, newDeadline);	
		}
	}

	public Integer deleteGoal(Integer id){
		return this.factory.deleteGoal(id);
	}

	public Collection<Goal> findAllGoals(){
		return this.factory.getAllGoals();
	}
}