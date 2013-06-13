package com.expedia.common.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

public class Weather {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weather [zipCode=" + zipCode + ", city=" + city + ", state="
				+ state + ", currentTemp=" + currentTemp + "]";
	}

	@NotEmpty
	@Length(min = 5, max = 5)
	@NumberFormat
	String zipCode;

	String city;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the currentTemp
	 */
	public String getCurrentTemp() {
		return currentTemp;
	}

	/**
	 * @param currentTemp
	 *            the currentTemp to set
	 */
	public void setCurrentTemp(String currentTemp) {
		this.currentTemp = currentTemp;
	}

	String state;
	String currentTemp;

	private String errorDesc;

	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @param description
	 */
	public void setErrorDesc(String description) {
		this.errorDesc = description;
	}
}