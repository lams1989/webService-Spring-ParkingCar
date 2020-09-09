package com.lams1989.rest.webservices.parkingcar.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id" })
public class TicketDto {

	private Integer id;
	private String registry;
	private String brand;
	private String ownerName;
	private LocalDateTime entryDate;
	private LocalDateTime outDate;
	private Long payment;
	private String timeElapsed;

	public TicketDto() {
		super();
	}

	public TicketDto(String registry, String brand, String ownerName, LocalDateTime entryDate,
			LocalDateTime outDate, Long payment, String timeElapsed) {
		super();
		this.registry = registry;
		this.brand = brand;
		this.ownerName = ownerName;
		this.entryDate = entryDate;
		this.outDate = outDate;
		this.payment = payment;
		this.timeElapsed = timeElapsed;
	}

	public String getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(String timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getOutDate() {
		return outDate;
	}

	public void setOutDate(LocalDateTime outDate) {
		this.outDate = outDate;
	}

	public Long getPayment() {
		return payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
	}

}
