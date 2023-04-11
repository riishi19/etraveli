package com.weather.alert.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "LocWeather")
public class LocWeather {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="locationid", insertable=false, updatable=false)
	private long locationid;
	
	@Column(name="weatherid", insertable=false, updatable=false)
	private long weatherid ;
	
	@Column
	private double min_temp;

	@Column
	private double max_temp;
	
	
	@OneToMany( mappedBy = "locWeather")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Location> location;
	
	@OneToMany( mappedBy = "locWeather")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Weather> weather;

	public LocWeather() {
	}
	
	protected LocWeather(long id, long locationid, long weatherid, double mintemparature, double maxtemparature) {
		this.id=id;
		this.locationid=locationid;
		this.weatherid=weatherid;
		this.min_temp=mintemparature;
		this.max_temp=maxtemparature;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the location
	 */
	public List<Location> getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(List<Location> location) {
		this.location = location;
	}

	/**
	 * @return the weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
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
	 * @return the min_temp
	 */
	public double getMin_temp() {
		return min_temp;
	}

	/**
	 * @param min_temp the min_temp to set
	 */
	public void setMin_temp(double min_temp) {
		this.min_temp = min_temp;
	}

	/**
	 * @return the max_temp
	 */
	public double getMax_temp() {
		return max_temp;
	}

	/**
	 * @param max_temp the max_temp to set
	 */
	public void setMax_temp(double max_temp) {
		this.max_temp = max_temp;
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
	
}
