package com.lams1989.rest.webservices.parkingcar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lams1989.rest.webservices.parkingcar.beans.ParkingCar;
import com.lams1989.rest.webservices.parkingcar.service.ParkingCarDaoService;

@RestController
public class ParkingCarController {
	
	@Autowired
	private ParkingCarDaoService service;
	
	@Autowired
	private MessageSource message;
	Logger logger = LoggerFactory.getLogger(ParkingCarController.class);
	
	@GetMapping("/parkingcars")
	public List<ParkingCar> retrieveAllUsers() {
		logger.info(message.getMessage("info.parking.car.getall.info", null, LocaleContextHolder.getLocale()));
		return service.findAll();
	}
}
