/**
 * DisplayLocation.java
 *
 * Created by Di007Va
 * Created on Jun 12, 2013
 * 
 * 
 * Copyright (c) 2013 Symbiont Softwares
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Symbiont Softwares.  You shall use it only in accordance with the terms
 * of the license agreement you entered into with Symbiont Softwares.
 *
 */
package com.expedia.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Di007Va
 * 
 */
@XStreamAlias("display_location")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DisplayLocation {
	private String full;
	private String city;
	private String state;
	@XStreamAlias("state_name")
	@JsonProperty("state_name")
	private String stateName;
	private String country;
	@JsonProperty("country_iso3166")
	@XStreamAlias("country_iso3166")
	private String countryISO;
	private String zip;
	private String latitude;
	private String longitude;
	private String elevation;

	/**
	 * @return the full
	 */
	public String getFull() {
		return full;
	}

	/**
	 * @param full
	 *            the full to set
	 */
	public void setFull(String full) {
		this.full = full;
	}

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
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName
	 *            the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the countryISO
	 */
	public String getCountryISO() {
		return countryISO;
	}

	/**
	 * @param countryISO
	 *            the countryISO to set
	 */
	public void setCountryISO(String countryISO) {
		this.countryISO = countryISO;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the elevation
	 */
	public String getElevation() {
		return elevation;
	}

	/**
	 * @param elevation
	 *            the elevation to set
	 */
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
}
