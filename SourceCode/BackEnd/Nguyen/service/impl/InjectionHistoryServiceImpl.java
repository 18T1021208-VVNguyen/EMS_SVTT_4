package com.laptrinhspringboot.vn.service.iml;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhspringboot.vn.convert.Convert;
import com.laptrinhspringboot.vn.dto.InjectionHistoryDTO;
import com.laptrinhspringboot.vn.entity.InjectionHistory;
import com.laptrinhspringboot.vn.repositories.InjectionHistoryRepository;
import com.laptrinhspringboot.vn.service.IInjectionHistoryService;

@Service
public class InjectionHistoryServiceImpl implements IInjectionHistoryService {

	@Autowired
	private InjectionHistoryRepository injectionHistoryRepository;
	@Override
	public InjectionHistoryDTO getTop1SortInjectionDate(Long customerID) {
		
	InjectionHistory  e = injectionHistoryRepository.getTop1SortInjectionDate(customerID);
		if(e !=null)
			return Convert.HistoryDTOToEntity(e);
	return null;
	
	}

}
