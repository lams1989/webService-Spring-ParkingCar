package com.lams1989.rest.webservices.parkingcar.repositiry;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lams1989.rest.webservices.parkingcar.beans.Ticket;

@Repository
public interface ParkingCarRepository extends JpaRepository<Ticket, Integer> {


	@Query("SELECT t FROM Ticket t WHERE t.outDate IS NULL AND t.registry = ?1 ")
	Ticket findByRegistryAndOutDateNull(String registry);
	
	List<Ticket> findByRegistryAndOutDateIsNull(String registry);

	

}
