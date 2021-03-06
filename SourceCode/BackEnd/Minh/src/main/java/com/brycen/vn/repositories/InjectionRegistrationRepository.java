package com.brycen.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.vn.entity.InjectionRegistration;

@Repository
public interface InjectionRegistrationRepository extends JpaRepository<InjectionRegistration, Long>{

}

