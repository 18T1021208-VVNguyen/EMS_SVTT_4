package com.laptrinhspringboot.vn.payload.response;

import java.util.Date;
import java.util.List;

import com.laptrinhspringboot.vn.dto.DistrictDTO;
import com.laptrinhspringboot.vn.dto.InjectionCalendarDTO;
import com.laptrinhspringboot.vn.dto.InjectionHistoryDTO;
import com.laptrinhspringboot.vn.dto.WardDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInjectCalendar {

	private Long customerID;
	private Date today;
	private String district;
	private String ward;
	private Integer page ;
	
	private InjectionHistoryDTO injectionHistory;
	private List<Integer> injectionNum;
	private List<DistrictDTO> listDistrict;
	private List<WardDTO> listWard;
	private List<InjectionCalendarDTO> injectionCalendar;
}
