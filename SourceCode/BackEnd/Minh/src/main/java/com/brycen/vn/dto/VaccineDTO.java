package com.brycen.vn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDTO extends BaseDTO{
	private String code;
	private Long categoryVaccineID;
	private String name;
	private String exprirationDate;
	private String manufacturingDate;
	private String producer;
	private String description;
	
}
