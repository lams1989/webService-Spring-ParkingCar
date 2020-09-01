package com.lams1989.rest.webservices.parkingcar.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Ticket")
public class ParkingCar {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 6, max = 10, message = "the registry me must be between 6 and 10 characters")
	private String registry;

	@Size(min = 2, max = 15, message = "the registry me must be between 2 and 15 characters")
	private String brand;

	@Size(min = 3, max = 50, message = "the registry me must be between 3 and 50 characters")
	@Column(name="Oner_name")
	private String ownerName;
	
	@Column(name="Entry_date")
	private Date entryDate;

	@Column(name="Out_date")
	private Date outDate;
	
	private Long payment;

	public ParkingCar() {
		super();
	}

	public ParkingCar(Integer id, String registry, String brand, String ownerName, Date entryDate, Date outDate,
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

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
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
