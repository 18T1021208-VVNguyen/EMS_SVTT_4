package com.brycen.vn.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.vn.config.SecurityUtils;
import com.brycen.vn.config.UserDetailsImpl;
import com.brycen.vn.dto.LoginRequest;
import com.brycen.vn.dto.LoginResponse;
import com.brycen.vn.dto.UserDTO;
import com.brycen.vn.dto.UserResponse;
import com.brycen.vn.service.iml.JwtService;
import com.brycen.vn.service.iml.UserDetailsServiceImpl;
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

	@Autowired
	 AuthenticationManager authenManager;
	// login
	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody LoginRequest login) {
		try {
			Authentication authentication  = authenManager.authenticate(
					new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
			UserDetailsImpl s = (UserDetailsImpl) authentication.getPrincipal();
			LoginResponse response = new LoginResponse();
			response.setToken(jwtService.generateTokenLogin(authentication.getName()));
			List<String> roles = s.getAuthorities().stream().map(role->
			role.getAuthority()).collect(Collectors.toList());
			response.setRoles(roles);
			response.setId(s.getId());
			response.setUsername(s.getUsername());
			return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
