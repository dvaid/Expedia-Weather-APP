/**
 * ApplicationUtil.java
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
package com.expedia.util;

import com.expedia.model.Response;
import com.expedia.model.ResponseJSON;
import com.expedia.model.Weather;

/**
 * @author Di007Va
 * 
 */
public class ApplicationUtil {

	/**
	 * @param weatherResponse
	 * @param weather
	 */
	public static void assemble(Response weatherResponse, Weather weather) {

		if (null != weatherResponse.getError()
				&& null != weatherResponse.getError().getDescription()) {
			weather.setErrorDesc(weatherResponse.getError().getDescription());
		} else {
			weather.setCity(weatherResponse.getCurrentObservation()
					.getObservationLocation().getCity());
			weather.setCurrentTempF(weatherResponse.getCurrentObservation()
					.getTempF());
			weather.setState(weatherResponse.getCurrentObservation()
					.getObservationLocation().getState());
			weather.setCurrentTempC(weatherResponse.getCurrentObservation()
					.getTempC());

		}
	}

	/**
	 * @param weatherResponse
	 * @param weather
	 */
	public static void assembleJSON(ResponseJSON weatherResponse,
			Weather weather) {

		if (null != weatherResponse.getError()
				&& null != weatherResponse.getError().getDescription()) {
			weather.setErrorDesc(weatherResponse.getError().getDescription());
		} else {
			weather.setCity(weatherResponse.getCurrentObservation()
					.getObservationLocation().getCity());
			weather.setCurrentTempF(weatherResponse.getCurrentObservation()
					.getTempF());
			weather.setState(weatherResponse.getCurrentObservation()
					.getObservationLocation().getState());
			weather.setCurrentTempC(weatherResponse.getCurrentObservation()
					.getTempC());

		}
	}

}
