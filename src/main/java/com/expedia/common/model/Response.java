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
package com.expedia.common.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Di007Va
 * 
 */
@XStreamAlias("response")
public class Response {

	private String version;
	private String termsofService;
	private List<Feature> features;

	/**
	 * @return the error
	 */
	public com.expedia.common.model.Error getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(com.expedia.common.model.Error error) {
		this.error = error;
	}

	private com.expedia.common.model.Error error;

	/**
	 * @return the features
	 */
	public List<Feature> getFeatures() {
		return features;
	}

	/**
	 * @param features
	 *            the features to set
	 */
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the termsofService
	 */
	public String getTermsofService() {
		return termsofService;
	}

	/**
	 * @param termsofService
	 *            the termsofService to set
	 */
	public void setTermsofService(String termsofService) {
		this.termsofService = termsofService;
	}

	@XStreamAlias("current_observation")
	private CurrentObservation currentObservation;

	/**
	 * @return the currentObservation
	 */
	public CurrentObservation getCurrentObservation() {
		return currentObservation;
	}

	/**
	 * @param currentObservation
	 *            the currentObservation to set
	 */
	public void setCurrentObservation(CurrentObservation currentObservation) {
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
