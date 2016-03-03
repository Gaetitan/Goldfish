package com.polytech.goldfish.persistence.jdbc;

import java.sql.Date;

import com.polytech.goldfish.businesslogic.business.Quotation;

/**
 * Persistence class for a Quotation
 * @author Gaëtan FRANÇOIS
 *
 */
public class QuotationJDBC extends Quotation {
	// Queries
	
	// Constructors
	public QuotationJDBC(Integer num_quotation, Date date, Float price) {
		super(num_quotation, date, price);
	}

	// Other methods
	
}
