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
