package com.weather.alert.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Weather")
public class Weather {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long weatherid ;
	
	@Column
	private String apiname;
	
	
	@ManyToOne()
	@JoinColumn(name = "weatherid", insertable=false, updatable=false)
    private LocWeather locWeather;
	
	
	public Weather() {
	}

	protected Weather(String api, long weatherid) {
		this.apiname = api;
		this.weatherid = weatherid;
	}
	

	/**
	 * @return the weatherid
	 */
	public long getWeatherid() {
		return weatherid;
	}

	/**
	 * @param weatherid the weatherid to set
	 */
	public void setWeatherid(long weatherid) {
		this.weatherid = weatherid;
	}

	/**
	 * @return the api
	 */
	public String getApiname() {
		return apiname;
	}

	/**
	 * @param api the api to set
	 */
	public void setApiname(String api) {
		this.apiname = api;
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
