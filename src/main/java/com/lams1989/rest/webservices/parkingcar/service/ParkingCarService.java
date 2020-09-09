package com.lams1989.rest.webservices.parkingcar.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lams1989.rest.webservices.parkingcar.beans.Ticket;
import com.lams1989.rest.webservices.parkingcar.dto.TicketDto;
import com.lams1989.rest.webservices.parkingcar.exception.CarIsParkingNowException;
import com.lams1989.rest.webservices.parkingcar.exception.OutOfTimeException;
import com.lams1989.rest.webservices.parkingcar.repositiry.ParkingCarRepository;
import com.lams1989.rest.webservices.parkingcar.util.Util;

@Service
public class ParkingCarService {

	@Autowired
	private ParkingCarRepository repository;

	public List<Ticket> findAll() {

		return repository.findAll();
	}

	public Ticket save(Ticket ticketCar) {

		List<Ticket> list = repository.findByRegistryAndOutDateIsNull(ticketCar.getRegistry());

		if (!list.isEmpty()) {
			throw new CarIsParkingNowException(
					"the car whit registry:" + ticketCar.getRegistry() + " is parking right now");
		}

		ticketCar.setEntryDate(LocalDateTime.now());

		// <<< comparar si la hora de entrada es superior a la permitida

		LocalTime actualTime = LocalTime.now();
		LocalTime closeTime = LocalTime.parse("23:59:59.000");
		LocalTime openTime = LocalTime.parse("07:59:59.000");

		if (actualTime.isAfter(closeTime) || actualTime.isBefore(openTime)) {
			throw new OutOfTimeException(
					"The car whit registry: " + ticketCar.getRegistry() + " Don't entry now, the ParkingCar is closed");
		}

		if (ticketCar.getOwnerName() == null) {
			ticketCar.setOwnerName("occasional customer");
		}
		if (ticketCar.getBrand() == null) {
			ticketCar.setBrand("Generic Brand");
		}
		return repository.save(ticketCar);
	}

	public TicketDto getRegistry(String registry) {
		List<Ticket> list = repository.findByRegistryAndOutDateIsNull(registry);

		if (list.isEmpty()) {
			throw new CarIsParkingNowException("the car with registry:" + registry + " not parking now");
		}

		Ticket ticket = list.get(0);

		String timeElapsed = Util.calculate(ticket, ticket.getEntryDate());

		TicketDto ticketDto = new TicketDto(ticket.getRegistry(), ticket.getBrand(), ticket.getOwnerName(),
				ticket.getEntryDate(), null, ticket.getPayment(), timeElapsed);

		return ticketDto;

	}

	public TicketDto setPayment(String registry) {
		List<Ticket> list = repository.findByRegistryAndOutDateIsNull(registry);

		if (list.isEmpty()) {
			list = repository.findByRegistryAndOutDateIsNotNull(registry);
		}

		Ticket ticket = list.get(0);

		String timeElapsed = Util.calculate(ticket, ticket.getEntryDate());

		repository.save(ticket);

		TicketDto ticketDto = new TicketDto(ticket.getRegistry(), ticket.getBrand(), ticket.getOwnerName(),
				ticket.getEntryDate(), ticket.getOutDate(), ticket.getPayment(), timeElapsed);

		return ticketDto;

	}

	

}
