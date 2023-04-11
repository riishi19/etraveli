package com.weather.alert.service;

import java.util.List;

import com.weather.alert.entities.LocWeather;
import com.weather.user.entities.User;
import com.weather.user.entities.UserPreference;

public interface NotificationService {
	public List<LocWeather> findAll();

	public void sendAlert(List<UserPreference> notificationList);

	public void getNotificationList(List<UserPreference> notificationList, User user, LocWeather locWeather);
}
