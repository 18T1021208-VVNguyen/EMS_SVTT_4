package com.brycen.vn.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

	@OneToMany(mappedBy = "address")
	private List<InjectionCalendar> injectionCalendars;
	
	


}
