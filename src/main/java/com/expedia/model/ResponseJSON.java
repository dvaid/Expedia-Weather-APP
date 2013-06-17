/**
 * Response.java
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
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author Di007Va
 * 
 */
@JsonRootName("response")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseJSON {

	/**
	 * @return the error
	 */
	public com.expedia.model.Error getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(com.expedia.model.Error error) {
		this.error = error;
	}

	private com.expedia.model.Error error;

	@JsonProperty("current_observation")
	private CurrentObservationJSON currentObservation;

	/**
	 * @return the currentObservation
	 */
	public CurrentObservationJSON getCurrentObservation() {
		return currentObservation;
	}

	/**
	 * @param currentObservation
	 *            the currentObservation to set
	 */
	public void setCurrentObservation(CurrentObservationJSON currentObservation) {
		this.currentObservation = currentObservation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [currentObservation=" + currentObservation + "]";
	}

}
