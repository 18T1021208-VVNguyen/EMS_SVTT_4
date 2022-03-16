package com.laptrinhspringboot.vn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhspringboot.vn.entity.InjectionHistory;

public interface InjectionHistoryRepository  extends  JpaRepository<InjectionHistory, Long>{

	@Query(nativeQuery = true, value = " select * from injection_history "
			+ " where customer_id = ?1 "
			+ " order by injection_date "
			+ " DESC LIMIT 1")
	InjectionHistory getTop1SortInjectionDate(Long id);
}
