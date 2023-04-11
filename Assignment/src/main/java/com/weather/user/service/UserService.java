package com.weather.user.service;

import java.util.List;

import com.weather.user.entities.User;

public interface UserService {
	public List<User> findAll();
	
	public void save(User user);
	
	public List<User> listAll();
	
	public User get(Long id);
	
	public User getUser(String email, String password);
	
}
