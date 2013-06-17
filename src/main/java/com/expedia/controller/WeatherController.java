package com.expedia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expedia.client.RESTServiceClient;
import com.expedia.model.Weather;

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
			weather = (Weather) serviceClient.getXMLResponse(weather);
			if (null != weather.getErrorDesc()) {
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
			weather = (Weather) serviceClient.getJSONResponse(weather);
			if (null != weather.getErrorDesc()) {
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