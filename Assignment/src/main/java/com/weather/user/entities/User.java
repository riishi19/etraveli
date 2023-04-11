package com.weather.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.weather.alert.entities.Location;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;

	@Column
	private String password;

	@Column
	private String name;

	@Column
	private String address;

	@Column
	private int age;

	@Column
	private String email;

	@Column
	private String mobile;
	
	@Column(name="city", insertable=false, updatable=false)
	private String city;

	@Column
	private double temp_range;

	@Column
	private String alert_type;

	@Column
	private String notification_channel;

	@OneToOne()
	@JoinColumn(name = "city")
	private Location location;

	public User() {
	}

	protected User(long userid, String password, String address, String name, String email, int age, int city,
			String mobile, double range, String alertType, String notification_channel) {
		this.userid = userid;
		this.password = password;
		this.address = address;
		this.name = name;
		this.email = email;
		this.age = age;
		this.mobile = mobile;
		this.alert_type = alertType;
		this.temp_range = range;
		this.notification_channel = notification_channel;
	}

	/**
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the temp_range
	 */
	public double getTemp_range() {
		return temp_range;
	}

	/**
	 * @param temp_range the temp_range to set
	 */
	public void setTemp_range(double temp_range) {
		this.temp_range = temp_range;
	}

	/**
	 * @return the alert_type
	 */
	public String getAlert_type() {
		return alert_type;
	}

	/**
	 * @param alert_type the alert_type to set
	 */
	public void setAlert_type(String alert_type) {
		this.alert_type = alert_type;
	}

	/**
	 * @return the notification_channel
	 */
	public String getNotification_channel() {
		return notification_channel;
	}

	/**
	 * @param notification_channel the notification_channel to set
	 */
	public void setNotification_channel(String notification_channel) {
		this.notification_channel = notification_channel;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
