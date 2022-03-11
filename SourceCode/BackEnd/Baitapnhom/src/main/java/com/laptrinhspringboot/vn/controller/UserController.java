package com.laptrinhspringboot.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhspringboot.vn.dto.UserDTO;
import com.laptrinhspringboot.vn.entity.User;
import com.laptrinhspringboot.vn.service.JwtService;
import com.laptrinhspringboot.vn.service.iml.UserService;

@RestController
@RequestMapping("/congthongtin")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public ResponseEntity<String> LoginUser(@RequestBody User user) {
		String result = "";
		HttpStatus httpStatus = null;
		try {
			if (userService.checkLogin(user.getUsername(), user.getPassword())) {
				result = jwtService.generateTokenLogin(user.getUsername());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		return new ResponseEntity<List<UserDTO>>(userService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserById(@PathVariable Long id) {
		UserDTO user = userService.findByid(id);
		if (user != null) {
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not Found User", HttpStatus.NO_CONTENT);
	}

}
