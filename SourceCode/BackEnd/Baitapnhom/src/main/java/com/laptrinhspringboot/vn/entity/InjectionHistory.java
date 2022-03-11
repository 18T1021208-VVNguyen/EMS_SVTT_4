package com.laptrinhspringboot.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "injection_history")
public class InjectionHistory extends Base {

	@Column(name = "injection_date", columnDefinition = "DATETIME NOT NULL")
	private String injectionDate;

	@Column(name = "address", columnDefinition = "VARCHAR(255) NOT NULL")
	private String address;

	@Column(name = "number_injection", columnDefinition = "VARCHAR(255) NOT NULL")
	private String numberInjection;

	@Column(name = "vaccineName", columnDefinition = "VARCHAR(255) NOT NULL")
	private String vaccineName;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public InjectionHistory(String injectionDate, String address, String numberInjection, String vaccineName,
			Customer customer) {
		super();
		this.injectionDate = injectionDate;
		this.address = address;
		this.numberInjection = numberInjection;
		this.vaccineName = vaccineName;
		this.customer = customer;
	}

	public String getInjectionDate() {
		return injectionDate;
	}

	public void setInjectionDate(String injectionDate) {
		this.injectionDate = injectionDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberInjection() {
		return numberInjection;
	}

	public void setNumberInjection(String numberInjection) {
		this.numberInjection = numberInjection;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
