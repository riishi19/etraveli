package com.weather.alert.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.weather.user.entities.User;

@Entity
@Table(name = "Location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="locationid", insertable=true, updatable=true, unique=false)
	private long locationid;

	@Column
	private String locationname;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="location")
	private User user;
	
	
	@ManyToOne()
	@JoinColumn(name = "locationid", insertable=false, updatable=false)
    private LocWeather locWeather;

	public Location() {
	}

	protected Location(String locationname, long locationid) {
		this.locationname = locationname;
		this.locationid = locationid;
	}

	/**
	 * @return the id
	 */
	public String getLocationName() {
		return locationname;
	}

	/**
	 * @param id the id to set
	 */
	public void setLocationName(String locationname) {
		this.locationname = locationname;
	}

	/**
	 * @return the locationid
	 */
	public long getLocationid() {
		return locationid;
	}

	/**
	 * @param locationid the locationid to set
	 */
	public void setLocationid(long locationid) {
		this.locationid = locationid;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the locationname
	 */
	public String getLocationname() {
		return locationname;
	}

	/**
	 * @param locationname the locationname to set
	 */
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	/**
	 * @return the locWeather
	 */
	public LocWeather getLocWeather() {
		return locWeather;
	}

	/**
	 * @param locWeather the locWeather to set
	 */
	public void setLocWeather(LocWeather locWeather) {
		this.locWeather = locWeather;
	}

}
