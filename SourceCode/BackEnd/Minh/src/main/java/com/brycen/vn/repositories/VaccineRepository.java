package com.brycen.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.vn.entity.Vaccine;
@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long>{
	
}
