package com.brycen.vn.service;

import com.brycen.vn.dto.CustomerDTO;
import com.brycen.vn.dto.User_CustomerDTO;

public interface ICustomerService {
	
	CustomerDTO getCustomerById(Long id);
	
	boolean save(User_CustomerDTO user_CustomerDTO);
	
	boolean getCustomerByIdentification(String identification);
	
	
	

}
