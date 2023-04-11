/**
 * 
 */
package com.weather.user.controller;

import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import com.weather.alert.entities.Location;
import com.weather.user.entities.User;
import com.weather.user.repository.UserRepository;
import com.weather.user.service.UserService;
import com.weather.user.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

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
		//if we don't call below, we will get NullPointerException
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public final void testSaveUser() {
		fail("Not yet implemented"); // TODO
	}
	
	
	@Test
	public void test() {
		String username = "riishi19@gmail.com";
		String password = "mohan";
		User user = getUserObject();
		System.out.println("Hi");
		userRepository= mock(UserRepository.class);
		when(userRepository.getUser(username, password)).thenReturn(user);
		
		assertEquals("Rishi", user.getName());
		UserService userService = new UserServiceImpl(userRepository);
		
		verify(userService.getUser(username, password));
	}

	
	@Test
	public final void testLogin() {
		String username = "riishi19@gmail.com";
		String password = "mohan";
		User user = getUserObject();

		userRepository= mock(UserRepository.class);
		when(userRepository.getUser(username, password)).thenReturn(user);
		// Given
		UserController controller = new UserController();

		UserService userService = new UserServiceImpl(userRepository);
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("home", user);

		given(controller.login(username, password)).willReturn(mav);
		controller.login(username, password);
		verify(userService.getUser(username, password));

		fail("Not yet implemented"); // TODO
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
