package com.expedia.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expedia.common.client.RESTServiceClient;
import com.expedia.common.model.Weather;

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
	@RequestMapping(value = "/retrieve", method = RequestMethod.POST)
	public String getWeather(@Valid Weather weather, BindingResult result) {

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
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String displayWeatherForm(ModelMap model) {

		model.addAttribute("weather", new Weather());
		return "WeatherForm";

	}

}