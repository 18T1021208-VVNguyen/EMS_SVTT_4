package com.laptrinhspringboot.vn.service.iml;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhspringboot.vn.dto.CustomerDTO;
import com.laptrinhspringboot.vn.entity.Customer;
import com.laptrinhspringboot.vn.repositories.CustomerRepository;
import com.laptrinhspringboot.vn.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CustomerDTO getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id).get();
		CustomerDTO customerDTO = modelmapper.map(customer, CustomerDTO.class);
		return customerDTO;
	}

	@Override
	public boolean createOrUpdateCustomer(Customer customer) {
		if(customer!=null) {
			customerRepository.save(customer);
			return true;
		}
		return false;
	}



}
