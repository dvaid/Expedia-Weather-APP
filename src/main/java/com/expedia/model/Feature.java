/**
 * Feature.java
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

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Di007Va
 * 
 */
@XStreamAlias("feature")
public class Feature {
	private String feature;

	/**
	 * @return the feature
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * @param feature
	 *            the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

}
