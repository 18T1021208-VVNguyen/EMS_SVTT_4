package com.brycen.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.vn.dto.CustomerDTO;
import com.brycen.vn.dto.User_CustomerDTO;
import com.brycen.vn.service.iml.CustomerServiceImpl;
import com.brycen.vn.service.iml.UserService;

@RestController
@RequestMapping("/congthongtin")
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private UserService userService;

	@GetMapping("/customer")
	public ResponseEntity<Object> getCustomerById(@PathVariable Long id) {
		CustomerDTO customerDTO = customerServiceImpl.getCustomerById(id);
		if (customerDTO != null) {
			return new ResponseEntity<Object>(customerDTO, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not Found customer", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/register")
	public ResponseEntity<String> createOrUpdate(@RequestBody User_CustomerDTO usCustomerDTO) {
		if (customerServiceImpl.getCustomerByIdentification(usCustomerDTO.getIdentification())
				|| userService.findByName(usCustomerDTO.getName())) {
			return new ResponseEntity<String>("Identification Existed! ", HttpStatus.FOUND);
		} else {
			if (customerServiceImpl.registerCustomer(usCustomerDTO)) {
				return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>("User Existed!", HttpStatus.BAD_REQUEST);
			}
		}

	}

}
