package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.Order;

/**
 * Persistence class for an Order
 * @author Gaëtan FRANÇOIS
 *
 */
public class OrderJDBC extends Order {

	// Queries
	
	
	// Constructors
	public OrderJDBC(Integer num_order, Date date, Float shipping_cost,
			Float price) {
		super(num_order, date, shipping_cost, price);
		// TODO Auto-generated constructor stub
	}

	// Other methods
}
