package com.lams1989.rest.webservices.parkingcar.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lams1989.rest.webservices.parkingcar.beans.ParkingCar;

@Component
public class ParkingCarDaoService {
	private static List<ParkingCar> cars = new ArrayList<>();

	static {
		cars.add(new ParkingCar(1, "jpa123", "Chevrolet", "luis", new Date(),null, 200L));
		cars.add(new ParkingCar(2, "mvn456", "Ford", "pedro", new Date(),null, 400L));
		cars.add(new ParkingCar(3, "xxp025", "Susuki", "juan", new Date(),null, 2000L));
		cars.add(new ParkingCar(4, "noq762", "yamaha", "augusto", new Date(),null, 500L));
		cars.add(new ParkingCar(5, "mvc567", "Renault", "amiliano", new Date(),null, 300L));
	}

	public List<ParkingCar> findAll() {

		return cars;
	}

	

}
