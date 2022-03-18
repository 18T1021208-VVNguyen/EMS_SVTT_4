package com.brycen.vn.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.vn.config.SecurityUtils;
import com.brycen.vn.dto.CustomerDTO;
import com.brycen.vn.dto.UserResponse;
import com.brycen.vn.dto.User_CustomerDTO;
import com.brycen.vn.entity.User;
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
	
	@Autowired
	private ModelMapper modelMapper;
	

	@GetMapping("/customer")
	public ResponseEntity<Object> getCustomerById(@PathVariable Long id) {
		CustomerDTO customerDTO = customerServiceImpl.getCustomerById(id);
		if (customerDTO != null) {
			return new ResponseEntity<Object>(customerDTO, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not Found customer", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User_CustomerDTO usCustomerDTO) {
		if (customerServiceImpl.getCustomerByIdentification(usCustomerDTO.getIdentification())
				|| userService.findByName(usCustomerDTO.getName())) {
			return new ResponseEntity<String>("Identification Existed! ", HttpStatus.FOUND);
		} else {
			if (customerServiceImpl.save(usCustomerDTO)) {
				return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>("User Existed!", HttpStatus.BAD_REQUEST);
			}
		}

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProfile(@RequestBody User_CustomerDTO usCustomerDTO) {
		UserResponse userResponse = userService.findUser(SecurityUtils.getUserName());
		System.out.println("id"+ userResponse.getCustomerDTO().getId());
		usCustomerDTO.setId(userResponse.getCustomerDTO().getId());
		
		if (customerServiceImpl.save(usCustomerDTO)) {
			return new ResponseEntity<String>("update!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("update Existed!", HttpStatus.BAD_REQUEST);
		}

	}


}
