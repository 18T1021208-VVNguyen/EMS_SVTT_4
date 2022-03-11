package com.laptrinhspringboot.vn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "injection_calendar")
public class InjectionCalendar extends Base {

	@Column(name = "injection_date", columnDefinition = "DATETIME NOT NULL")
	private String injectionDate;

	@OneToMany(mappedBy = "injectionCalendar", cascade = CascadeType.ALL)
	private List<InjectionRegistration> injectionRegistrations;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;
	
	
	

	public InjectionCalendar(String injectionDate, List<InjectionRegistration> injectionRegistrations, Address address,
			Vaccine vaccine) {
		super();
		this.injectionDate = injectionDate;
		this.injectionRegistrations = injectionRegistrations;
		this.address = address;
		this.vaccine = vaccine;
	}

	public String getInjectionDate() {
		return injectionDate;
	}

	public void setInjectionDate(String injectionDate) {
		this.injectionDate = injectionDate;
	}

	public List<InjectionRegistration> getInjectionRegistrations() {
		return injectionRegistrations;
	}

	public void setInjectionRegistrations(List<InjectionRegistration> injectionRegistrations) {
		this.injectionRegistrations = injectionRegistrations;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	
}
