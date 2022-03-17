package com.brycen.vn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InjectionRegistrationDTO extends BaseDTO{
	private String customerName;
	private String customerIdentification;
	private String customerPhoneNumber;
	private String numberInjection;
	private String injectionCalendarAddressDistrict;
	private String injectionCalendarAddressWard;
	private String injectionCalendarAddress;
	private String injectionCalendarInjectionDate;
	private String injectionCalendarVaccineName;
	private Long status;
	
}
