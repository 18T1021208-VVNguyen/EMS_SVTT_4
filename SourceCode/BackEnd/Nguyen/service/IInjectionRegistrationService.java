package com.laptrinhspringboot.vn.service;

import java.util.Date;

public interface IInjectionRegistrationService {
	boolean checkRegistrationExpiredGreater( Long idCurtomer,Date today);
	boolean checkRegistrationExpiredEqual(Long idCurtomer,Date today);
	
}
