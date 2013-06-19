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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.expedia.model.Response;
import com.expedia.model.ResponseWrapper;
import com.expedia.model.Weather;

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
	@Value("#{wunderGroundClient['url.webservice.xml']}")
	private String weatherServiceXmlUrl;
	@Value("#{wunderGroundClient['url.webservice.json']}")
	private String weatherServiceJsonUrl;
	@Value("#{wunderGroundClient['url.webservice.api']}")
	private String weatherApiKey;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.common.client.RESTServiceClient#getXMLResponse(java.lang.
	 * Object)
	 */
	@Override
	public ResponseEntity<Response> getXMLResponse(Object request) {
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
				responseEntity = restTemplate.exchange(weatherServiceXmlUrl,
						HttpMethod.GET, httpEntity, Response.class, weatherApiKey,
						weather.getZipCode());
			} catch (RuntimeException e) {
				e.printStackTrace();
				weather.setErrorDesc("Get failed" + e.getMessage());
			}
		}
		return responseEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.expedia.common.client.RESTServiceClient#getJSONResponse(java.lang
	 * .Object)
	 */
	@Override
	public ResponseEntity<ResponseWrapper> getJSONResponse(Object request) {
		ResponseEntity<ResponseWrapper> responseEntity = null;
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
				System.out
						.println("Hitting weather service for JSON response!");
				responseEntity = restTemplate.exchange(weatherServiceJsonUrl,
						HttpMethod.GET, httpEntity, ResponseWrapper.class,
						weatherApiKey, weather.getZipCode());
			} catch (RuntimeException e) {
				e.printStackTrace();
				weather.setErrorDesc("Get failed" + e.getMessage());
			}
		}
		return responseEntity;
	}

}
