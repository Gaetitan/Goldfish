package com.polytech.goldfish.businesslogic.business;

/**
 * Business class Seller
 * @author Gaëtan FRANÇOIS
 *
 */
public class Seller extends Person {

	// Attributes
	private String shop_name;
	private String description;
	private String siret;
	private String activity_domain;
	private String web_adress;

	//Constuctors	
	public Seller(Integer id, String name, String surname, String phone_number,
			String email, String password) {
		super(id, name, surname, phone_number, email, password);
	}
	
	public Seller(Integer id, String name, String surname, String phone_number,
			String email, String password, String shop_name,
			String description, String siret, String activity_domain,
			String web_adress) {
		super(id, name, surname, phone_number, email, password);
		this.shop_name = shop_name;
		this.description = description;
		this.siret = siret;
		this.activity_domain = activity_domain;
		this.web_adress = web_adress;
	}

	// Getters & setters
	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getActivity_domain() {
		return activity_domain;
	}

	public void setActivity_domain(String activity_domain) {
		this.activity_domain = activity_domain;
	}

	public String getWeb_adress() {
		return web_adress;
	}

	public void setWeb_adress(String web_adress) {
		this.web_adress = web_adress;
	}
	
	// Other methods

}
