package com.brycen.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brycen.vn.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long>{
	
	@Query(value = "SELECT * FROM customer WHERE ID = (SELECT MAX(ID) FROM customer)",nativeQuery = true)
	Customer findByCustomer();
	
	Customer findByIdentification(String identification);
	
	


}
