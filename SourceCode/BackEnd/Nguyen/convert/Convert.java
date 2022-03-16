package com.laptrinhspringboot.vn.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.laptrinhspringboot.vn.dto.DistrictDTO;
import com.laptrinhspringboot.vn.dto.InjectionCalendarDTO;
import com.laptrinhspringboot.vn.dto.InjectionHistoryDTO;
import com.laptrinhspringboot.vn.dto.WardDTO;
import com.laptrinhspringboot.vn.entity.Address;
import com.laptrinhspringboot.vn.entity.InjectionCalendar;
import com.laptrinhspringboot.vn.entity.InjectionHistory;

public class Convert {

		public static InjectionCalendarDTO calendaEntityToDto(InjectionCalendar entity ) {
			InjectionCalendarDTO dto = new 	InjectionCalendarDTO();
			dto.setId(entity.getId());
			dto.setDistrict(entity.getAddress().getDistrict());
			dto.setWard(entity.getAddress().getWard());
			dto.setInjectionSite(entity.getAddress().getInjection_site());
			dto.setInjectionDate(entity.getInjectionDate());
			dto.setVaccineName(entity.getVaccine().getName());
			return dto;
		}
		
		public static List<Integer> getListNumberInjection(Integer num){
			List<Integer>  listNum = new ArrayList<>();
			for(int i=1;i<=num;i++)
			{
				listNum.add(i);
			}
			return listNum;
		}
		
		public static Date stringToDate (String dateText) throws ParseException {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.parse(dateText);
		}
		
		public static DistrictDTO addressToDistrictDTO( Address entity) {
			DistrictDTO dto = new DistrictDTO();
			dto.setId(entity.getId());
			dto.setDistrictName(entity.getDistrict());
			return dto;
		}
		public static WardDTO addressToWardtDTO( Address entity) {
			WardDTO dto = new WardDTO();
			dto.setId(entity.getId());
			dto.setWardName(entity.getWard());
			return dto;
		}
		
		public static InjectionHistoryDTO HistoryDTOToEntity(InjectionHistory entity) {
			InjectionHistoryDTO dto = new InjectionHistoryDTO();
			dto.setId(entity.getId());
			dto.setAddress(entity.getAddress());
			dto.setInjectionDate(entity.getInjectionDate());
			dto.setNumberInjection(entity.getNumberInjection());
			dto.setVaccineName(entity.getVaccineName());
			return dto;
			
		}
}
