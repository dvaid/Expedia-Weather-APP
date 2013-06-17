/**
 * WunderGroundClient.java
 *
 * Created by Di007Va
 * Created on Jun 11, 2013
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
package com.expedia.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperations;

import com.expedia.model.Response;
import com.expedia.model.ResponseJSON;
import com.expedia.model.Weather;
import com.expedia.util.ApplicationUtil;

/**
 * @author Di007Va
 * 
 */
@Component("serviceClient")
public class WunderGroundClient implements RESTServiceClient {

	@Autowired
	/**
	 * Facilitates communication with the wunderground weather api
	 */
	private RestOperations restTemplate;

	/**
	 * The base URL of the wunderground web service
	 */
	public static final String WEATHER_SERVICE_XML_URL = "http://api.wunderground.com/api/{apiKey}/conditions/q/{zip}.xml";
	public static final String WEATHER_SERVICE_JSON_URL = "http://api.wunderground.com/api/{apiKey}/conditions/q/{zip}.json";
	public static final String WEATHER_API = "ed044d75b91fb500";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.common.client.RESTServiceClient#getXMLResponse(java.lang.
	 * Object)
	 */
	@Override
	public Object getXMLResponse(Object request) {
		ResponseEntity<Response> responseEntity = null;
		Weather weather = null;

		if (request instanceof Weather) {
			weather = (Weather) request;
			List<MediaType> mediaTypes = new ArrayList<MediaType>();
			mediaTypes.add(MediaType.APPLICATION_XML);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(mediaTypes);
			HttpEntity<Weather> httpEntity = new HttpEntity<Weather>(null,
					headers);
			try {
				System.out.println("Hitting weather service!");
				responseEntity = restTemplate.exchange(WEATHER_SERVICE_XML_URL,
						HttpMethod.GET, httpEntity, Response.class,
						WEATHER_API, weather.getZipCode());
				Response weatherResponse = responseEntity.getBody();
				ApplicationUtil.assemble(weatherResponse, weather);

			} catch (HttpStatusCodeException e) {
				e.printStackTrace();
				weather.setErrorDesc("Get failed with HttpStatusCode: "
						+ e.getStatusCode() + "|" + e.getStatusText());
			} catch (RuntimeException e) {
				e.printStackTrace();
				weather.setErrorDesc("Get failed" + e.getMessage());
			}
		}
		return weather;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.common.client.RESTServiceClient#getJSONResponse(java.lang
	 * .Object)
	 */
	@Override
	public Object getJSONResponse(Object request) {
		ResponseEntity<ResponseJSON> responseEntity = null;
		Weather weather = null;

		if (request instanceof Weather) {
			weather = (Weather) request;
			List<MediaType> mediaTypes = new ArrayList<MediaType>();
			mediaTypes.add(MediaType.APPLICATION_JSON);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(mediaTypes);
			HttpEntity<Weather> httpEntity = new HttpEntity<Weather>(null,
					headers);
			try {
				System.out.println("Hitting weather service for JSON response!");
				responseEntity = restTemplate.exchange(WEATHER_SERVICE_JSON_URL,
						HttpMethod.GET, httpEntity, ResponseJSON.class,
						WEATHER_API, weather.getZipCode());
				ResponseJSON weatherResponse = responseEntity.getBody();
				System.out.println("weatherResponse --> " + weatherResponse);
				ApplicationUtil.assembleJSON(weatherResponse, weather);

			} catch (HttpStatusCodeException e) {
				e.printStackTrace();
				weather.setErrorDesc("Get failed with HttpStatusCode: "
						+ e.getStatusCode() + "|" + e.getStatusText());
			} catch (RuntimeException e) {
				e.printStackTrace();
				weather.setErrorDesc("Get failed" + e.getMessage());
			}
		}
		return weather;
	}

}
