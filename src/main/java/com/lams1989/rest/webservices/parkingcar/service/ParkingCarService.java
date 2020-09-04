package com.lams1989.rest.webservices.parkingcar.service;

import java.time.Duration;
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
		TicketDto ticketDto = new TicketDto(ticket.getId(), ticket.getRegistry(), ticket.getBrand(),
				ticket.getOwnerName(), ticket.getEntryDate());

		LocalDateTime actualTime = LocalDateTime.now();
		Duration duration = Duration.between(ticket.getEntryDate(), actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);
		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);

		ticketDto.setTimeElapsed(timeElapsed);

		/*
		 * 1 Hora o fraccion 4.000. 5, 10 ,20 1 hora despues de la hora la fraccion 1000
		 * Despues de la hora. 1:29 -> 6000 0 - 60 -> 4000 60 - 75 -> 5000 75 - 90 ->
		 * 6000 10 horas -> no deberia cobrar 40K si no 30k 1/2 Dia(12 Horas) -> 30.000
		 * 1 dia vale(24 horas) -> 50.000
		 * 
		 * 0 days 2 hours 53 minutes
		 * 12000	8000 
		 * "2 days 5 hours 53 minutes"
		 */
		//solo minutos 
		// hora fija
		//dia
		//1/2 dia
		//dia y 1/2
		//hora mas minutos
		long fractionHour = 4000;
		long fractionMinutes = 1000;
		long fractionDay = 50000;
		long pay = 0;

		if (days >= 1) {
			pay += fractionDay * days;
		}

		if (hours == 12) {
			pay += 30000;
			if (minutes <= 15) {
				pay += fractionMinutes;
			} else if (minutes > 15 && minutes <= 30) {
				pay += fractionMinutes * 2;
			} else if (minutes > 30 && minutes <= 45) {
				pay += fractionMinutes * 3;
			} else if (minutes > 45 && minutes < 59) {
				pay += fractionMinutes * 4;
			}

		}
		if (hours > 0 && hours != 12) {
			pay += fractionHour * hours;
		}

		if (minutes > 0 && minutes < 60 && hours > 0 && hours != 12) {
			if (minutes <= 15) {
				pay += fractionMinutes;
			} else if (minutes > 15 && minutes <= 30) {
				pay += fractionMinutes * 2;
			} else if (minutes > 30 && minutes <= 45) {
				pay += fractionMinutes * 3;
			} else if (minutes > 45 && minutes < 59) {
				pay += fractionMinutes * 4;
			}
		}
		
		if (minutes > 0 && minutes < 60 && hours == 0 && hours != 12) {
			pay += fractionHour;
			
		}
	

		ticketDto.setPayment(pay);

		return ticketDto;
	}

}
