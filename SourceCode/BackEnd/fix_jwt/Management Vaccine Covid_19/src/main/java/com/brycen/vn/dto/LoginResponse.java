package com.brycen.vn.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
  private String token;
  private List<String> roles;
  private Long id;
  private String username;
}
