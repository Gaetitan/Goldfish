package com.polytech.goldfish.businesslogic.manager;

import java.sql.Date;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	boolean checkDeadlinde(String deadline){
		Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher m = p.matcher(deadline);
		return m.matches();
	}

	public GoalManager(){
		this.factory = new GoalFactoryJDBC();
	}

	public Integer createGoal(Integer idPerson, String name, String description, String deadline) throws GoldfishException {
		if(name.isEmpty() || name == "" || description.isEmpty() || description == ""){
			throw new GoldfishException("Goal name nor description can be empty.");
		}
		else if(!checkDeadlinde(deadline)) {
			throw new GoldfishException("Please enter a valid deadline format: YYYY-MM-DD.");
		}
		else{
			Date deadlineParsed = java.sql.Date.valueOf(deadline);
			return this.factory.createGoal(idPerson, name, description, deadlineParsed);	
		}
	}

	public Integer updateGoal(Integer idGoal, String newName, String newDescription, String newDeadline) throws GoldfishException{
		if(newName.isEmpty() || newName == "" || newDescription.isEmpty() || newDescription == ""){
			throw new GoldfishException("Goal name nor description can be empty.");
		}
		else if(!checkDeadlinde(newDeadline)) {
			throw new GoldfishException("Please enter a valid deadline format: YYYY/MM/DD.");
		}
		else{
			Date newDeadlineParsed = java.sql.Date.valueOf(newDeadline);
			return this.factory.updateGoal(idGoal, newName, newDescription, newDeadlineParsed);	
		}
	}

	public boolean deleteGoal(Integer id){
		return this.factory.deleteGoal(id);
	}

	public Collection<Goal> findAllGoals(){
		return this.factory.getAllGoals();
	}
}