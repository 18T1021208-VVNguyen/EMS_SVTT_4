package com.laptrinhspringboot.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhspringboot.vn.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
