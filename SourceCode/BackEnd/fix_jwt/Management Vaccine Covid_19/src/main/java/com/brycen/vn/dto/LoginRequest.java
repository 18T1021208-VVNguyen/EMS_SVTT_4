package com.brycen.vn.dto;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class LoginRequest {
	private String username;
	private String password;
}
