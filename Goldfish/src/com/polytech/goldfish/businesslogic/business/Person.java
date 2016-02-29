package com.polytech.goldfish.businesslogic.business;

public class Person {

	private final Integer id;
	private final String email;
	private final String password;
	
	public Person(Integer id, String email, String password){
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPassword(){
		return this.password;
	}
}
