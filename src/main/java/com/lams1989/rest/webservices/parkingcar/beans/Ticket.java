package com.lams1989.rest.webservices.parkingcar.beans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Ticket {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 6, max = 10, message = "the registry me must be between 6 and 10 characters")
	private String registry;

	@Size(min = 2, max = 15, message = "the registry me must be between 2 and 15 characters")
	private String brand;

	@Size(min = 3, max = 50, message = "the registry me must be between 3 and 50 characters")
	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "entry_date")
	private LocalDateTime entryDate;

	@Column(name = "out_date")
	private LocalDateTime outDate;

	private Long payment;

	public Ticket() {
		super();
	}

	public Ticket(Integer id, String registry, String brand, String ownerName, LocalDateTime entryDate, LocalDateTime outDate,
			Long payment) {
		super();
		this.id = id;
		this.registry = registry;
		this.brand = brand;
		this.ownerName = ownerName;
		this.entryDate = entryDate;
		this.outDate = outDate;
		this.payment = payment;
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

	@Override
	public String toString() {
		return "ParkingCar [id=" + id + ", registry=" + registry + ", brand=" + brand + ", ownerName=" + ownerName
				+ ", entryDate=" + entryDate + ", outDate=" + outDate + ", payment=" + payment + "]";
	}

}
