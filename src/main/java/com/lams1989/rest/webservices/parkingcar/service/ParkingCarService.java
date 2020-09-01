package com.lams1989.rest.webservices.parkingcar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lams1989.rest.webservices.parkingcar.beans.Ticket;
import com.lams1989.rest.webservices.parkingcar.exception.CarIsParkingNowException;
import com.lams1989.rest.webservices.parkingcar.exception.TicketNotFoundException;
import com.lams1989.rest.webservices.parkingcar.repositiry.ParkingCarRepository;

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
			throw new CarIsParkingNowException("the car whit registry:" + ticketCar.getRegistry() +" is parking right now");
		}
		if (ticketCar.getOwnerName() == null) {
			ticketCar.setOwnerName("occasional customer");
		}
		if (ticketCar.getBrand() == null) {
			ticketCar.setBrand("Generic Brand");
		}
		return repository.save(ticketCar);
	}
}
