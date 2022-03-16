package com.laptrinhspringboot.vn.service;

import com.laptrinhspringboot.vn.dto.InjectionHistoryDTO;
import com.laptrinhspringboot.vn.entity.InjectionHistory;

public interface IInjectionHistoryService {
	InjectionHistoryDTO getTop1SortInjectionDate(Long customerID);
}
