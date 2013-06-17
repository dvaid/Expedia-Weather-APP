/**
 * CurrentObservation.java
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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author Di007Va
 * 
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrentObservationJSON {

	private ObservationLocationJSON observationLocation;
	@JsonProperty("temp_f")
	private String tempF;
	@JsonProperty("temp_c")
	private String tempC;


	/**
	 * @return the forecast_url
	 */
	public String getForecast_url() {
		return forecast_url;
	}

	/**
	 * @param forecast_url
	 *            the forecast_url to set
	 */
	public void setForecast_url(String forecast_url) {
		this.forecast_url = forecast_url;
	}

	/**
	 * @return the history_url
	 */
	public String getHistory_url() {
		return history_url;
	}

	/**
	 * @param history_url
	 *            the history_url to set
	 */
	public void setHistory_url(String history_url) {
		this.history_url = history_url;
	}

	/**
	 * @return the ob_url
	 */
	public String getOb_url() {
		return ob_url;
	}

	/**
	 * @param ob_url
	 *            the ob_url to set
	 */
	public void setOb_url(String ob_url) {
		this.ob_url = ob_url;
	}

	private String forecast_url;
	private String history_url;
	private String ob_url;

	/**
	 * @return the observationLocation
	 */
	public ObservationLocationJSON getObservationLocation() {
		return observationLocation;
	}

	/**
	 * @param observationLocation
	 *            the observationLocation to set
	 */

	@JsonProperty("observation_location")
	public void setObservationLocation(ObservationLocationJSON observationLocation) {
		this.observationLocation = observationLocation;
	}

	/**
	 * @return the tempF
	 */
	public String getTempF() {
		return tempF;
	}

	/**
	 * @param tempF
	 *            the tempF to set
	 */
	public void setTempF(String tempF) {
		this.tempF = tempF;
	}

	/**
	 * @return the tempC
	 */
	public String getTempC() {
		return tempC;
	}

	/**
	 * @param tempC
	 *            the tempC to set
	 */
	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrentObservation [observationLocation=" + observationLocation
				+ ", tempF=" + tempF + ", tempC=" + tempC + "]";
	}

}
