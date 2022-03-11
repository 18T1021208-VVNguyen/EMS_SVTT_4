package com.laptrinhspringboot.vn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends Base {

	@Column(name = "district", columnDefinition = "VARCHAR(255) NOT NULL")
	private String district;

	@Column(name = "ward", columnDefinition = "VARCHAR(255) NOT NULL")
	private String ward;

	@Column(name = "injection_site", columnDefinition = "VARCHAR(255) NOT NULL")
	private String injection_site;

	@Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
	private String description;

	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private List<InjectionCalendar> injectionCalendars;

	public Address(String district, String ward, String injection_site, String description,
			List<InjectionCalendar> injectionCalendars) {
		super();
		this.district = district;
		this.ward = ward;
		this.injection_site = injection_site;
		this.description = description;
		this.injectionCalendars = injectionCalendars;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getInjection_site() {
		return injection_site;
	}

	public void setInjection_site(String injection_site) {
		this.injection_site = injection_site;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<InjectionCalendar> getInjectionCalendars() {
		return injectionCalendars;
	}

	public void setInjectionCalendars(List<InjectionCalendar> injectionCalendars) {
		this.injectionCalendars = injectionCalendars;
	}

}
