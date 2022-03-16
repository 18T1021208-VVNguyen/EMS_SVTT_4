package com.laptrinhspringboot.vn.service.iml;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhspringboot.vn.entity.InjectionRegistration;
import com.laptrinhspringboot.vn.repositories.InjectionRegistrationRepository;
import com.laptrinhspringboot.vn.service.IInjectionRegistrationService;

@Service
public class InjectionRegistrationServiceImpl implements IInjectionRegistrationService {
	
	@Autowired
	private InjectionRegistrationRepository injectionRegistrationRepository;
	
	@Override
	public boolean checkRegistrationExpiredGreater(Long idCurtomer,Date today) {
		List<InjectionRegistration> list=	injectionRegistrationRepository.getRegistrationExpiredGreater(idCurtomer,today );
		if(list.isEmpty() || list==null)
			return false;
		return true;
	}

	@Override
	public boolean checkRegistrationExpiredEqual( Long idCurtomer,Date today) {
		List<InjectionRegistration> list=	injectionRegistrationRepository.getRegistrationExpiredEqual(idCurtomer,today );
		if(list.isEmpty() || list==null)
			return false;
		return true;
	}
	
}
