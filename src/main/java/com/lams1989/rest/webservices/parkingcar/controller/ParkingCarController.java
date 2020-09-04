package com.lams1989.rest.webservices.parkingcar.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lams1989.rest.webservices.parkingcar.beans.Ticket;
import com.lams1989.rest.webservices.parkingcar.dto.TicketDto;
import com.lams1989.rest.webservices.parkingcar.service.ParkingCarService;

@RestController
public class ParkingCarController {
	
	@Autowired
	private ParkingCarService service;
	
	
	@Autowired
	private MessageSource message;
	Logger logger = LoggerFactory.getLogger(ParkingCarController.class);
	
	@GetMapping("/parkingcars")
	public List<Ticket> retrieveAllUsers() {
		logger.info(message.getMessage("info.parking.car.getall.info", null, LocaleContextHolder.getLocale()));
		return service.findAll();
	}
	
	@PostMapping("/parkingcars")
	public Ticket createTicket(@Valid @RequestBody Ticket ticketCar) {
		logger.info(message.getMessage("info.parking.car.created.info", null, LocaleContextHolder.getLocale()));
		
		ticketCar = service.save(ticketCar);
		
		return ticketCar;

	}
	
	@GetMapping("/parkingcars/{registry}")
	public TicketDto getRegistry(@PathVariable String registry) {
		logger.info(message.getMessage("info.parking.car.getid.info", null, LocaleContextHolder.getLocale()));
		
		TicketDto ticket = service.getRegistry(registry);

		return ticket;
	}
	
	
}
