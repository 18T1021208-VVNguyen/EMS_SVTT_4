package com.brycen.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.vn.entity.CategoryVaccine;

@Repository
public interface CategoryVaccineRepository extends JpaRepository<CategoryVaccine, Long>{

}
