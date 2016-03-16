package com.polytech.goldfish.businesslogic.business;

/**
 * Business class Person
 * 
 * @author Gaëtan FRANÇOIS
 *
 */
public class Person {

	// Attributes
	private Integer id;
	private String surname;
	private String name;
	private String phone_number;
	private String email;
	private String password;

	// Constructors
	public Person(Integer id, String surname, String name, String phone_number,
			String email, String password) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.phone_number = phone_number;
		this.email = email;
		this.password = password;
	}

	// Getters & setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
