package com.polytech.goldfish.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.polytech.goldfish.businesslogic.business.User;

public class UserTests {
	
	protected User user;
	protected User user1;
	
	@Before
	public void setUp(){
		user = new User(10000, "AName", "ASurname", "0123456789", "example@gmail.com", "password");
		user1 = new User(10001, "AName", "ASurname", "0123456789", "example1@gmail.com", "password");
	}

	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test() {
		
		assertNotSame(user1, user); // Assert that user1 and user are not the same object
		assertSame(user1.getName(), user.getName()); // Assert that user1 and user share the same name
		assertSame(user1.getSurname(), user.getSurname()); // Same surname
		assertSame(user1.getPhone_number(), user.getPhone_number()); // Same phone number
		assertNotSame(user1.getEmail(), user.getEmail()); // But not same email 
		assertSame(user1.getPassword(), user.getPassword()); // Ans same password

		String name = "ANewName";
		String surname = "ANewSurname";
		String phone = "9876543210";
		String mail = "example@NEWGmail.com";
		String password = "ANewpassword";
				
		user.setName(name); // We change the name, surname, phone, mail and password
		user.setSurname(surname);
		user.setPhone_number(phone);
		user.setEmail(mail);
		user.setPassword(password);
		
		assertNotNull(user);
		assertEquals(name, user.getName()); // Then we check again
		assertEquals(surname, user.getSurname());
		assertEquals(phone, user.getPhone_number());
		assertEquals(mail, user.getEmail());
		assertEquals(password, user.getPassword());
	}

}
