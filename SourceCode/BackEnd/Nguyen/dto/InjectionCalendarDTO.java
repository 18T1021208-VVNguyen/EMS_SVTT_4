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
public class InjectionCalendarDTO {
	private Long id;
	private String district ;
	private String ward;
	private String injectionSite;
	private Date injectionDate;
	private String vaccineName;
}
