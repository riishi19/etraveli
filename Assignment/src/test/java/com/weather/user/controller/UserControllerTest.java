/**
 * 
 */
package com.weather.user.controller;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.weather.alert.entities.Location;
import com.weather.user.entities.User;
import com.weather.user.repository.UserRepository;

/**
 * @author riish
 *
 */

public class UserControllerTest {

	//@Mock
	//private UserService userService;

	 
	@InjectMocks
	UserRepository userRepository;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public final void testSaveUser() {
		
	}
	
	
	@Test
	public void test() {
		String username = "riishi19@gmail.com";
		String password = "mohan";
		User user = getUserObject();
		System.out.println("Hi");
		
	}

	
	@Test
	public final void testLogin() {
		String username = "riishi19@gmail.com";
		String password = "mohan";
		User user = getUserObject();

	}

	private User getUserObject() {

		User user = new User();
		user.setEmail("Rishi");
		user.setName("Rishi");
		user.setLocation(new Location());
		user.setAlert_type("SMS");
		return user;
	}
}
