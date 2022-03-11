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
@Table(name = "vaccine")
public class Vaccine extends Base {

	@Column(name = "code", columnDefinition = "VARCHAR(255) NOT NULL ",unique = true)
	private String code;

	@Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL ")
	private String name;

	@Column(name = "description", columnDefinition = "VARCHAR(255) NOT NULL")
	private String description;

	@Column(name = "expriration_date", columnDefinition = "DATETIME NOT NULL")
	private String exprirationDate;

	@Column(name = "manufacturing_date", columnDefinition = "DATETIME NOT NULL")
	private String manufacturingDate;

	@Column(name = "producer", columnDefinition = "VARCHAR(255) NOT NULL")
	private String producer;

	@OneToMany(mappedBy = "vaccine", cascade = CascadeType.ALL)
	private List<InjectionCalendar> injectionCalendars;

	@ManyToOne
	@JoinColumn(name = "category_vaccine_id")
	private CategoryVaccine categoryVaccine;

	public Vaccine(String code, String name, String description, String exprirationDate, String manufacturingDate,
			String producer, List<InjectionCalendar> injectionCalendars, CategoryVaccine categoryVaccine) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.exprirationDate = exprirationDate;
		this.manufacturingDate = manufacturingDate;
		this.producer = producer;
		this.injectionCalendars = injectionCalendars;
		this.categoryVaccine = categoryVaccine;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExprirationDate() {
		return exprirationDate;
	}

	public void setExprirationDate(String exprirationDate) {
		this.exprirationDate = exprirationDate;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public List<InjectionCalendar> getInjectionCalendars() {
		return injectionCalendars;
	}

	public void setInjectionCalendars(List<InjectionCalendar> injectionCalendars) {
		this.injectionCalendars = injectionCalendars;
	}

	public CategoryVaccine getCategoryVaccine() {
		return categoryVaccine;
	}

	public void setCategoryVaccine(CategoryVaccine categoryVaccine) {
		this.categoryVaccine = categoryVaccine;
	}

}
