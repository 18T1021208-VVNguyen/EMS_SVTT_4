package com.laptrinhspringboot.vn.service.iml;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhspringboot.vn.convert.Convert;
import com.laptrinhspringboot.vn.dto.DistrictDTO;
import com.laptrinhspringboot.vn.dto.WardDTO;
import com.laptrinhspringboot.vn.entity.Address;
import com.laptrinhspringboot.vn.repositories.AddressRepository;
import com.laptrinhspringboot.vn.service.IAddressService;
@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;
	@Override
	public List<DistrictDTO> getAllDistrict() {
		List<Address> listEntity = addressRepository.getAllDistric();
		List<DistrictDTO> listDTO = listEntity.stream()
							.map(item -> Convert.addressToDistrictDTO(item)).collect(Collectors.toList());
		Set<String> elements = new LinkedHashSet<>();
		listDTO.removeIf(item -> !elements.add(item.getDistrictName() ) );
		elements.clear();
		return listDTO;
	}
	@Override
	public List<WardDTO> getWardWhereDistric(String district) {
		List<Address> listEntity = addressRepository.getWardWhereDistric(district);
		List<WardDTO> listDTO  = listEntity.stream().map(item -> Convert.addressToWardtDTO(item) ).collect(Collectors.toList());
		return listDTO;
	}

	
	
	

}
