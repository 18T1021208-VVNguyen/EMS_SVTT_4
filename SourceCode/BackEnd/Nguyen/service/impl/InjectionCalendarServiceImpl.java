package com.laptrinhspringboot.vn.service.iml;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhspringboot.vn.convert.Convert;
import com.laptrinhspringboot.vn.dto.DistrictDTO;
import com.laptrinhspringboot.vn.dto.InjectionCalendarDTO;
import com.laptrinhspringboot.vn.dto.InjectionHistoryDTO;
import com.laptrinhspringboot.vn.entity.InjectionCalendar;
import com.laptrinhspringboot.vn.payload.response.ResponseInjectCalendar;
import com.laptrinhspringboot.vn.repositories.InjectionCalendarRepository;
import com.laptrinhspringboot.vn.service.IInjectionCalendarService;
@Service
public class InjectionCalendarServiceImpl implements IInjectionCalendarService {

	@Autowired
	private InjectionCalendarRepository injectionCalendarRepository;

	@Autowired 
	private AddressServiceImpl  addressServiceImpl;

	@Autowired
	private InjectionHistoryServiceImpl injectionHistoryServiceImpl;
	
	@Override
	public List<InjectionCalendarDTO> getAllInjectionCalendar(Date today, Pageable pageable) {
		List<InjectionCalendar> listEntity  = injectionCalendarRepository.getAllAllow(today, pageable).toList();
		List<InjectionCalendarDTO> listDTO = listEntity.stream().map(item -> Convert.calendaEntityToDto(item))
				.collect(Collectors.toList());
		return listDTO;
	}


	@Override
	public List<InjectionCalendarDTO> getAllowByDistrict(Date today, String district, Pageable pageable) {
		List<InjectionCalendar> listEntity  = injectionCalendarRepository.getAllowByDistrict(today, district, pageable).toList();
		List<InjectionCalendarDTO> listDTO = listEntity.stream().map(item -> Convert.calendaEntityToDto(item))
				.collect(Collectors.toList());
		return listDTO;
	}

	@Override
	public List<InjectionCalendarDTO> getAllowByDistrictAndWard(Date today, String district, String ward,
			Pageable pageable) {
		List<InjectionCalendar> listEntity  = injectionCalendarRepository.getAllowByDistrictAndWard(today, district, ward,pageable).toList();
		List<InjectionCalendarDTO> listDTO = listEntity.stream().map(item -> Convert.calendaEntityToDto(item))
				.collect(Collectors.toList());
		return listDTO;
	}


	@Override
	public ResponseInjectCalendar getResponseInjectCalendar(Long customerid, Date today, String district, String ward,
			Integer page) {
		ResponseInjectCalendar result = new ResponseInjectCalendar();
		
		result.setCustomerID(customerid);
		result.setToday(today);
		result.setDistrict(district);
		result.setWard(ward);
		if(page ==null) page =0 ; 
		result.setPage(page);
		List<Integer> numInjection = Convert.getListNumberInjection(8);
		result.setInjectionNum(numInjection);
		
		List<DistrictDTO> listDistrict = addressServiceImpl.getAllDistrict();
		result.setListDistrict(listDistrict);
		
		InjectionHistoryDTO history = injectionHistoryServiceImpl.getTop1SortInjectionDate(customerid);
		result.setInjectionHistory(history);
		
		Page
		if(district==null && ward ==null ){
			this.getAllInjectionCalendar(today);
		}
		return result;
	}
	
	
}
