package com.brycen.vn.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface IInjectionRegistrationService {
	
	ResponseEntity<Map<String, Object>> gellAll(int page);
	
	boolean confirm(Long id);
	
	boolean cancel(Long id);
}
