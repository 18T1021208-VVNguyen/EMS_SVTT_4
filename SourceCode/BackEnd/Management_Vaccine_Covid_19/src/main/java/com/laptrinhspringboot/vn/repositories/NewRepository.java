package com.laptrinhspringboot.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhspringboot.vn.entity.New;

@Repository
public interface NewRepository extends JpaRepository<New, Long>{

}
