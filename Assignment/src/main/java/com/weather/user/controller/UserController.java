package com.weather.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.weather.user.entities.User;
import com.weather.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("/new")
	public String newUserForm(Map<String, Object> model) {
		User user = new User();
		model.put("user", user);
		return "registration";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public ModelAndView editUserForm(@RequestParam String userid) {
		ModelAndView mav = new ModelAndView("location");
		User user = userService.get(Long.parseLong(userid));
		mav.addObject("location", user);

		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email, @RequestParam String password) {
		User user = null;
		ModelAndView mav = null;

		if (email.isBlank() || password.isBlank()) {
			mav = new ModelAndView("index");	
		}else {
			user = userService.getUser(email, password);
			System.out.println(user.getEmail());
			mav = new ModelAndView("home");
			mav.addObject("home", user);		
		}
		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(@RequestParam String email, @RequestParam String password) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

}
