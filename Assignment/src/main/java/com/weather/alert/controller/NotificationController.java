package com.weather.alert.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weather.alert.entities.LocWeather;
import com.weather.alert.entities.Location;
import com.weather.alert.service.NotificationService;
import com.weather.user.entities.User;
import com.weather.user.entities.UserPreference;
import com.weather.user.service.UserService;

@Controller
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;

	

	@RequestMapping("/alert")
	public ModelAndView getNotification() {

		List<LocWeather> locList = notificationService.findAll();

		List<User> userlist = userService.findAll();

		List<UserPreference> notificationList = new ArrayList<>();

		//Try to use flat map here
		
		
		for (User user : userlist) {
			for (LocWeather locWeather : locList) {
				//Double averagePercentage = locWeather.stream().collect(Collectors.averagingDouble(locWeather.getMax_temp()::getPercentage));
				for (Location location : locWeather.getLocation()) {
					
					if (user.getLocation().getLocationid() == location.getLocationid()) {
						//Get Average first
						
						notificationService.getNotificationList(notificationList, user, locWeather);
					}
				}
			}
		}
		if (null != notificationList && notificationList.size() >= 1) {
			notificationService.sendAlert(notificationList);

		}
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("home", notificationList);
		return mav;
	}


	/*
	 * A cron expression to execute at every thirty minutes
	 *
	 */
	@Scheduled(cron = "* */30 * * * *")
	public void Scheduled() {
		System.out.println("Scheduler execute at every thirty minutes");
		getNotification();
	}

}
