package com.lams1989.rest.webservices.parkingcar.repositiry;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lams1989.rest.webservices.parkingcar.beans.Ticket;

@Repository
public interface ParkingCarRepository extends JpaRepository<Ticket, Integer> {

	
	List<Ticket> findByRegistryAndOutDateIsNull(String registry);
	
	List<Ticket> findByRegistryAndOutDateIsNotNull(String registry);

	

}
