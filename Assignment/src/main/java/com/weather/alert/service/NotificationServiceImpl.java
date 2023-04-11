package com.weather.alert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weather.alert.entities.LocWeather;
import com.weather.alert.repository.NotificationRepository;
import com.weather.type.NotificationChannel;
import com.weather.user.entities.User;
import com.weather.user.entities.UserPreference;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService{
	
	@Autowired(required=true)
	@Qualifier("notificationRepository")
	private NotificationRepository notificationRepository; 
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<LocWeather> findAll() {
		return notificationRepository.findAll();
	}

	public void sendAlert( List<UserPreference> notificationList) {
		for (UserPreference notification : notificationList) {
			if (isNotificationSent(notification) == false) {
				if (notification.getChannel().equalsIgnoreCase(NotificationChannel.SMS.name())) {
	
					sendSMS(notification);
				}
				if (notification.getChannel().equalsIgnoreCase(NotificationChannel.EMAIL.name())) {
					sendMail(notification);
				}
				if (notification.getChannel().equalsIgnoreCase(NotificationChannel.APP_NOTIFICATION.name())) {
					sendAppNotification(notification);
				}
				updateNotification(notification);
			}
			
		}
	
	}
	

	public void getNotificationList(List<UserPreference> notificationList, User user, LocWeather locWeather) {
		UserPreference objNotification = null;
		if (user.getAlert_type().equalsIgnoreCase("MAX")) {
			if (user.getTemp_range() < locWeather.getMax_temp()) {
				objNotification = new UserPreference();
				objNotification.setEmail(user.getEmail());
				objNotification.setChannel(user.getNotification_channel());
				notificationList.add(objNotification);
			}

		} else if (user.getAlert_type().equalsIgnoreCase("MIN")) {
			if (user.getTemp_range() > locWeather.getMin_temp()) {
				objNotification = new UserPreference();
				objNotification.setEmail(user.getEmail());
				objNotification.setChannel(user.getNotification_channel());
				notificationList.add(objNotification);
			}
		}
	}

	public void sendSMS(UserPreference notification) {
		System.out.println("SMS sent");
	}

	public void sendMail(UserPreference notification) {
		System.out.println("mail sent");
		// takes input from e-mail form
		String recipientAddress = "riishi19@gmail.com";
		String subject = "Severe Weather Alert";
		String message = "As per your location setting today's temparature";

	
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);

		// sends the e-mail
		mailSender.send(email);
	}

	public void sendAppNotification(UserPreference notification) {
		System.out.println("APP_NOTIFICATION sent");
	}

	/**
	 * This method will update notification once mail sent to user. 
	 * 
	 * @param notificationList
	 */
	public void updateNotification(UserPreference notificationList) {
		System.out.println("Update database table ");
	}
	
	/**
	 * This method will check before sending mail if system has already sent mail to user at least 1 hour. 
	 * 
	 * @param notificationList
	 */
	public boolean isNotificationSent(UserPreference notificationList) {
		boolean statusSent = false;
		System.out.println("Update database table ");
		return statusSent;
	}
}
