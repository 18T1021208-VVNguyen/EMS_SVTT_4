package com.laptrinhspringboot.vn.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhspringboot.vn.entity.InjectionCalendar;
public interface InjectionCalendarRepository  extends JpaRepository <InjectionCalendar ,Long> {

	@Query(nativeQuery = true, value="select * from injection_calendar  IC where IC.injection_date > ?1")
	Page<InjectionCalendar> getAllAllow(Date today,Pageable pageable);
	
	@Query(nativeQuery = true, value = "select IC.* from injection_calendar as IC join address as A on IC.address_id = A.id"
			+ " where IC.injection_date > ?1 and A.district = ?2 ")
	Page<InjectionCalendar> getAllowByDistrict(Date today,String district ,Pageable pageable  );
	
	@Query(nativeQuery = true, value = "select IC.* from injection_calendar as IC join address as A on IC.address_id = A.id"
			+ " where IC.injection_date > ?1 and A.district = ?2 and A.ward = ?3 ")
	Page<InjectionCalendar> getAllowByDistrictAndWard(Date today,String district , String Ward,Pageable pageable  );
	
}
	
