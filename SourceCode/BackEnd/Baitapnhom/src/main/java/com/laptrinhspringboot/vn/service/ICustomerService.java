package com.laptrinhspringboot.vn.service;

import com.laptrinhspringboot.vn.dto.CustomerDTO;
import com.laptrinhspringboot.vn.entity.Customer;

public interface ICustomerService {
	
	CustomerDTO getCustomerById(Long id);
	
	boolean createOrUpdateCustomer(Customer customer);

}
