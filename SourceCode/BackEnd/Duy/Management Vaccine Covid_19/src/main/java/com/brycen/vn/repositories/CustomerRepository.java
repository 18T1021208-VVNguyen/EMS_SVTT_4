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
	
	
	@Query(value = "SELECT c.id,c.created_at,c.created_user_id,c.deleted,c.modified_at,c.modified_user_id, \r\n"
			+ "c.address,c.birthday,c.code,c.email,c.ethnic,c.gender,c.health_insurance_number,\r\n"
			+ "c.identification,c.name,c.occupation,c.phone_number FROM baitapnhom2.customer AS c  \r\n"
			+ "join users as u on c.id = u.customer_id \r\n"
			+ "where u.username =?1",nativeQuery = true)
	Customer findByName(String username);

}
