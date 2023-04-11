package com.weather.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.weather.user.entities.User;


public interface UserRepository  extends CrudRepository<User, Long>{
	
	@Query(value = "SELECT u FROM User u ")
	public List<User> findAll();
	
	@Query(value = "SELECT u, ul.locationname FROM User u inner join u.location ul WHERE u.email = :email and u.password = :password")
	public User getUser(@Param("email") String email, @Param("password") String password);

}
