package com.laptrinhspringboot.vn.service;

import java.util.List;

import com.laptrinhspringboot.vn.dto.DistrictDTO;
import com.laptrinhspringboot.vn.dto.WardDTO;

public interface IAddressService {
	
	List<DistrictDTO> getAllDistrict();
	
	List<WardDTO> getWardWhereDistric(String district);
}
