package com.expedia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expedia.client.RESTServiceClient;
import com.expedia.model.Response;
import com.expedia.model.ResponseWrapper;
import com.expedia.model.Weather;
import com.expedia.util.ApplicationUtil;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	RESTServiceClient serviceClient;

	/**
	 * 
	 * @param weather
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/retrieve/xml", method = RequestMethod.POST)
	public String getWeatherXML(@Valid Weather weather, BindingResult result) {

		if (result.hasErrors()) {
			return "WeatherForm";
		} else {
			// hit the api service to find the weather data
			@SuppressWarnings("unchecked")
			ResponseEntity<Response> responseEntity = (ResponseEntity<Response>) serviceClient
					.getXMLResponse(weather);
			Response weatherResponse = responseEntity.getBody();
			System.out.println("weatherResponse --> " + weatherResponse
					+ "\n Status COde : " + responseEntity.getStatusCode()
					+ "\n Content Type : "
					+ responseEntity.getHeaders().getContentType());
			ApplicationUtil.assemble(weatherResponse, weather);
			if (HttpStatus.OK != responseEntity.getStatusCode()
					|| null != weather.getErrorDesc()) {
				result.rejectValue("zipCode", "NotFound.weather.zipCode",
						"Hard Coded Message");
			}
			return "WeatherForm";
		}

	}

	/**
	 * 
	 * @param weather
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/retrieve/json", method = RequestMethod.POST)
	public String getWeatherJSON(@Valid Weather weather, BindingResult result) {

		if (result.hasErrors()) {
			return "WeatherForm";
		} else {
			// hit the api service to find the weather data
			@SuppressWarnings("unchecked")
			ResponseEntity<ResponseWrapper> responseEntity = (ResponseEntity<ResponseWrapper>) serviceClient
					.getJSONResponse(weather);
			ResponseWrapper weatherResponse = responseEntity.getBody();
			System.out.println("weatherResponse --> " + weatherResponse
					+ "\n Status COde : " + responseEntity.getStatusCode()
					+ "\n Content Type : "
					+ responseEntity.getHeaders().getContentType());
			ApplicationUtil.assembleJSON(weatherResponse, weather);

			if (HttpStatus.OK != responseEntity.getStatusCode()
					|| null != weather.getErrorDesc()) {
				result.rejectValue("zipCode", "NotFound.weather.zipCode",
						"Hard Coded Message");
			}
			return "WeatherForm";
		}

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String displayWeatherForm(ModelMap model) {

		model.addAttribute("weather", new Weather());
		return "WeatherForm";

	}

}