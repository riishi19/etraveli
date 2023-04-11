package com.weather.alert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.weather.alert.entities.LocWeather;


public interface NotificationRepository  extends CrudRepository<LocWeather, Long>{
	
	@Query(value = "Select lt from LocWeather lt ")
	public List<LocWeather> findAll();
	
}
