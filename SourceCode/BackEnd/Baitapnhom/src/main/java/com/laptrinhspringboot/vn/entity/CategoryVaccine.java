package com.laptrinhspringboot.vn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_vaccine")
public class CategoryVaccine extends Base {

	@Column(name = "code", columnDefinition = "VARCHAR(255) NOT NULL", unique = true)
	private String code;

	@Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL")
	private String name;

	@OneToMany(mappedBy = "categoryVaccine", cascade = CascadeType.ALL)
	private List<Vaccine> vaccines;

	public CategoryVaccine(String code, String name, List<Vaccine> vaccines) {
		super();
		this.code = code;
		this.name = name;
		this.vaccines = vaccines;
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

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

}
