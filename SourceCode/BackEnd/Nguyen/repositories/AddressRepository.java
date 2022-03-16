package com.laptrinhspringboot.vn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhspringboot.vn.entity.Address;

public interface AddressRepository  extends  JpaRepository<Address, Long>{
	
	@Query(nativeQuery = true, value="select  * from address")
	List<Address> getAllDistric();
	
	@Query(nativeQuery = true, value="select * from address where district = ?1")
	List<Address> getWardWhereDistric(String district);

}
