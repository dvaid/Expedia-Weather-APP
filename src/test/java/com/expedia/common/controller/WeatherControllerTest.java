/**
 * WeatherControllerTest.java
 *
 * Created by Di007Va
 * Created on Jun 13, 2013
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
package com.expedia.common.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.ModelAndViewAssert.assertAndReturnModelAttributeOfType;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.common.model.Weather;

/**
 * @author Di007Va
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class WeatherControllerTest {

	@Autowired
	private ApplicationContext applicationContext;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private HandlerAdapter handlerAdapter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		handlerAdapter = applicationContext.getBean(HandlerAdapter.class);
	}

	@Test
	public void testGet() throws Exception {
		request.setMethod("GET");
		request.setRequestURI("/weather");
		final ModelAndView mav = handle(request, response);
		assertAndReturnModelAttributeOfType(mav, "weather", Weather.class);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	ModelAndView handle(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		final HandlerMapping handlerMapping = applicationContext
				.getBean(HandlerMapping.class);
		final HandlerExecutionChain handler = handlerMapping
				.getHandler(request);
		assertNotNull(
				"No handler found for request, check you request mapping",
				handler);

		final Object controller = handler.getHandler();
		// if you want to override any injected attributes do it here

		final HandlerInterceptor[] interceptors = handlerMapping.getHandler(
				request).getInterceptors();
		for (HandlerInterceptor interceptor : interceptors) {
			final boolean carryOn = interceptor.preHandle(request, response,
					controller);
			if (!carryOn) {
				return null;
			}
		}

		final ModelAndView mav = handlerAdapter.handle(request, response,
				controller);
		return mav;
	}

	@Test
	public void testPost() throws Exception {
		request.setMethod("POST");
		request.setRequestURI("/weather/retrieve");
		request.setParameter("zipCode", "23451");
		final ModelAndView mav = handle(request, response);
		final Weather weather = assertAndReturnModelAttributeOfType(mav,
				"weather", Weather.class);
		assertEquals(new Integer(23451), weather.getZipCode());
		/* if myForm is not valid */
		assertViewName(mav, "WeatherForm");
		final BindingResult errors = getBindingResult(mav, "weather");
		assertTrue(null != errors.getFieldError("zipCode") ? errors
				.getFieldError("zipCode").getDefaultMessage() : "",
				!errors.hasErrors());
	}

	/**
	 * 
	 * @param mav
	 * @param name
	 * @return
	 */
	private BindingResult getBindingResult(ModelAndView mav, String name) {
		BindingResult result = (BindingResult) mav.getModel().get(
				BindingResult.MODEL_KEY_PREFIX + name);
		assertTrue("No BindingResult for attribute: " + name, result != null);
		return result;
	}
}
