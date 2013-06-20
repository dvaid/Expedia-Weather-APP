/**
 * WunderGroundClientTest.java
 *
 * Created by Di007Va
 * Created on Jun 19, 2013
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

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.RequestMatchers.method;
import static org.springframework.test.web.client.match.RequestMatchers.requestTo;
import static org.springframework.test.web.client.response.ResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.expedia.model.ResponseWrapper;
import com.expedia.model.Weather;

/**
 * @author Di007Va
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class WunderGroundClientTest {
	private MockRestServiceServer mockServer;

	@Autowired
	WunderGroundClient serviceClient;

	@Before
	public void setUp() {
		mockServer = MockRestServiceServer
				.createServer((RestTemplate) serviceClient.getRestTemplate());
	}

	@Test
	public void testAddReturnCorrectResponse() throws Exception {

		final String responseXml = "{\"response\": {\"version\": \"0.1\""
				+ ",\"termsofService\": \"http://www.wunderground.com/weather/api/d/terms.html\""
				+ ",\"features\": {\"conditions\": 1}},\"current_observation\": {"
				+ "		\"image\": {"
				+ "		\"url\":\"http://icons-ak.wxug.com/graphics/wu2/logo_130x80.png\","
				+ "		\"title\":\"Weather Underground\","
				+ "		\"link\":\"http://www.wunderground.com\""
				+ "		},"
				+ "		\"display_location\": {"
				+ "		\"full\":\"Schenectady, NY\","
				+ "		\"city\":\"Schenectady\","
				+ "		\"state\":\"NY\","
				+ "		\"state_name\":\"New York\","
				+ "		\"country\":\"US\","
				+ "		\"country_iso3166\":\"US\","
				+ "		\"zip\":\"12345\","
				+ "		\"latitude\":\"42.81407928\","
				+ "		\"longitude\":\"-73.93997955\","
				+ "		\"elevation\":\"78.00000000\""
				+ "		},"
				+ "		\"observation_location\": {"
				+ "		\"full\":\"APRSWXNET Schenectady NY US, Schenectady, New York\","
				+ "		\"city\":\"APRSWXNET Schenectady NY US, Schenectady\","
				+ "		\"state\":\"New York\","
				+ "		\"country\":\"US\","
				+ "		\"country_iso3166\":\"US\","
				+ "		\"latitude\":\"42.817581\","
				+ "		\"longitude\":\"-73.927963\","
				+ "		\"elevation\":\"344 ft\""
				+ "		},"
				+ "		\"estimated\": {"
				+ "		},"
				+ "		\"station_id\":\"MD3701\","
				+ "		\"observation_time\":\"Last Updated on June 19, 6:20 AM EDT\","
				+ "		\"observation_time_rfc822\":\"Wed, 19 Jun 2013 06:20:00 -0400\","
				+ "		\"observation_epoch\":\"1371637200\","
				+ "		\"local_time_rfc822\":\"Wed, 19 Jun 2013 06:49:03 -0400\","
				+ "		\"local_epoch\":\"1371638943\","
				+ "		\"local_tz_short\":\"EDT\","
				+ "		\"local_tz_long\":\"America/New_York\","
				+ "		\"local_tz_offset\":\"-0400\","
				+ "		\"weather\":\"Partly Cloudy\","
				+ "		\"temperature_string\":\"51 F (10.6 C)\","
				+ "		\"temp_f\":51,"
				+ "		\"temp_c\":10.6,"
				+ "		\"relative_humidity\":\"91%\","
				+ "		\"wind_string\":\"From the North at 1 MPH Gusting to 2.0 MPH\","
				+ "		\"wind_dir\":\"North\","
				+ "		\"wind_degrees\":10,"
				+ "		\"wind_mph\":1,"
				+ "		\"wind_gust_mph\":\"2.0\","
				+ "		\"wind_kph\":1.6,"
				+ "		\"wind_gust_kph\":\"3.2\","
				+ "		\"pressure_mb\":\"1017\","
				+ "		\"pressure_in\":\"30.02\","
				+ "		\"pressure_trend\":\""
				+ "\","
				+ "		\"dewpoint_string\":\"48 F (9 C)\","
				+ "		\"dewpoint_f\":48,"
				+ "		\"dewpoint_c\":9,"
				+ "		\"heat_index_string\":\"NA\","
				+ "		\"heat_index_f\":\"NA\","
				+ "		\"heat_index_c\":\"NA\","
				+ "		\"windchill_string\":\"NA\","
				+ "		\"windchill_f\":\"NA\","
				+ "		\"windchill_c\":\"NA\","
				+ "		\"feelslike_string\":\"51 F (10.6 C)\","
				+ "		\"feelslike_f\":\"51\","
				+ "		\"feelslike_c\":\"10.6\","
				+ "		\"visibility_mi\":\"10.0\","
				+ "		\"visibility_km\":\"16.1\","
				+ "		\"solarradiation\":\"97\","
				+ "		\"UV\":\"0\","
				+ "		\"precip_1hr_string\":\"0.00 in ( 0 mm)\","
				+ "		\"precip_1hr_in\":\"0.00\","
				+ "		\"precip_1hr_metric\":\" 0\","
				+ "		\"precip_today_string\":\"0.00 in (0 mm)\","
				+ "		\"precip_today_in\":\"0.00\","
				+ "		\"precip_today_metric\":\"0\","
				+ "		\"icon\":\"partlycloudy\","
				+ "		\"icon_url\":\"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif\","
				+ "		\"forecast_url\":\"http://www.wunderground.com/US/NY/Schenectady.html\","
				+ "		\"history_url\":\"http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=MD3701\","
				+ "		\"ob_url\":\"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=42.817581,-73.927963\""
				+ "	}" + "}" + "";

		mockServer
				.expect(requestTo("http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/12345.json"))
				.andExpect(method(HttpMethod.GET))
				.andRespond(
						withSuccess(responseXml, MediaType.APPLICATION_JSON));
		Weather request = new Weather();
		request.setZipCode(12345);

		final ResponseEntity<ResponseWrapper> response = (ResponseEntity<ResponseWrapper>) serviceClient
				.getJSONResponse(request);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON.getSubtype(), response
				.getHeaders().getContentType().getSubtype());
		mockServer.verify();
	}

}