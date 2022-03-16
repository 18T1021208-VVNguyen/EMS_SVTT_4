package com.laptrinhspringboot.vn.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InjectionHistoryDTO {

	private Long id;
	private Integer numberInjection;
	private Date injectionDate;
	private String address;
	private String vaccineName;
}
