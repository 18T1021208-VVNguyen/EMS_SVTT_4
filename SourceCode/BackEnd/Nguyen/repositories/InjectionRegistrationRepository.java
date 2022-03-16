package com.laptrinhspringboot.vn.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhspringboot.vn.entity.InjectionRegistration;

public interface InjectionRegistrationRepository extends JpaRepository <InjectionRegistration ,Long>{
	
	@Query(nativeQuery = true, value ="select * from injection_registration  IR "
			+ "join injection_calendar  IC on IR.injection_calendar_id = IC.id"
			+ " where  IR.customer_id = ?1 and IC.injection_date > ?2")
	List<InjectionRegistration> getRegistrationExpiredGreater( Long i , Date today);
	
	@Query(nativeQuery = true, value ="select * from injection_registration  IR "
			+ "join injection_calendar  IC on IR.injection_calendar_id = IC.id"
			+ " where  IR.customer_id = ?1 and IC.injection_date = ?2")
	List<InjectionRegistration> getRegistrationExpiredEqual( Long i , Date today);
}
