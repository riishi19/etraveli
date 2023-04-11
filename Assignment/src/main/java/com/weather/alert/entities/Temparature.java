package com.weather.alert.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Temparature")
public class Temparature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int temparatureid;

	@Column
	private String temparaturename;

	public Temparature() {
	}

	protected Temparature(int temparatureid, String temparaturename) {
		this.temparatureid = temparatureid;
		this.temparaturename = temparaturename;
	}

	/**
	 * @return the temparatureid
	 */
	public int getTemparatureId() {
		return temparatureid;
	}

	/**
	 * @param temparatureid the temparatureid to set
	 */
	public void setTemparatureId(int temparatureid) {
		this.temparatureid = temparatureid;
	}

	/**
	 * @return the TemparatureName
	 */
	public String getTemparatureName() {
		return temparaturename;
	}

	/**
	 * @param TemparatureName the TemparatureName to set
	 */
	public void setTemparatureName(String temparaturename) {
		this.temparaturename = temparaturename;
	}

}
