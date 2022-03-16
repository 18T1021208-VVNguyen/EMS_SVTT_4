package com.laptrinhspringboot.vn.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhspringboot.vn.dto.InjectionCalendarDTO;
import com.laptrinhspringboot.vn.payload.response.ResponseInjectCalendar;


public interface IInjectionCalendarService {
	List<InjectionCalendarDTO > getAllInjectionCalendar(Date today , Pageable pageable);
	List<InjectionCalendarDTO > getAllowByDistrict(Date today , String district ,Pageable pageable);
	List<InjectionCalendarDTO > getAllowByDistrictAndWard(Date today , String district , String ward ,Pageable pageable);
	ResponseInjectCalendar getResponseInjectCalendar(Long customerid ,Date today, String district, 
			String ward, Integer page);
}
