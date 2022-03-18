package com.brycen.vn.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.vn.config.SecurityUtils;
import com.brycen.vn.dto.UserDTO;
import com.brycen.vn.dto.UserResponse;
import com.brycen.vn.entity.User;
import com.brycen.vn.service.iml.JwtService;
import com.brycen.vn.service.iml.UserService;

@RestController
@RequestMapping("/congthongtin")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private ModelMapper modelMapper;

	// login
	@PostMapping("/login")
	public ResponseEntity<String> LoginUser(@RequestBody UserDTO userdto) {
		User user = modelMapper.map(userdto, User.class);
		String result = "";
		HttpStatus httpStatus = null;
		try {
			System.out.println("username" + user.getUsername() + " password " + user.getPassword());
			if (userService.checkLogin(user.getUsername(), user.getPassword())) {
				result = jwtService.generateTokenLogin(user.getUsername());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception ex) {
			result = ex.getMessage();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}


	// admin hiển thị danh sách user
	@GetMapping("/admin/users")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		return new ResponseEntity<List<UserDTO>>(userService.getAll(), HttpStatus.OK);
	}

	// hiển thị profile
	@GetMapping("/profile")
	public ResponseEntity<UserResponse> getProfile() {
		return new ResponseEntity<UserResponse>(userService.findUser(SecurityUtils.getUserName()), HttpStatus.OK);
	}
	

}
