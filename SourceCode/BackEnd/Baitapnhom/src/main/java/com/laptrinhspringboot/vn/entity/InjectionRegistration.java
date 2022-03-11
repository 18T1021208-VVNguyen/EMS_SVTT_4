package com.laptrinhspringboot.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "injection_registration")
public class InjectionRegistration extends Base {

	@Column(name = "status", columnDefinition = "BIGINT NOT NULL")
	private String status;

	@Column(name = "number_injection", columnDefinition = "VARCHAR(255) NOT NULL")
	private Long numberInjection;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "injection_calendar_id")
	private InjectionCalendar injectionCalendar;

	public InjectionRegistration(String status, Long numberInjection, Customer customer,
			InjectionCalendar injectionCalendar) {
		super();
		this.status = status;
		this.numberInjection = numberInjection;
		this.customer = customer;
		this.injectionCalendar = injectionCalendar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNumberInjection() {
		return numberInjection;
	}

	public void setNumberInjection(Long numberInjection) {
		this.numberInjection = numberInjection;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InjectionCalendar getInjectionCalendar() {
		return injectionCalendar;
	}

	public void setInjectionCalendar(InjectionCalendar injectionCalendar) {
		this.injectionCalendar = injectionCalendar;
	}

}
