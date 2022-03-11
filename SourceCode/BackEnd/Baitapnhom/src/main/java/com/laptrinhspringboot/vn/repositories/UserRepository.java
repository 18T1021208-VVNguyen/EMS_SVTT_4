package com.laptrinhspringboot.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhspringboot.vn.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsernameAndPassword(String usename, String password);
	
	User findByUsername(String username);
	
}
