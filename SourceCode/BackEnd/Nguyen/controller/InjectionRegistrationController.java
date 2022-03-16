package com.laptrinhspringboot.vn.controller.injectionRegistration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhspringboot.vn.convert.Convert;
import com.laptrinhspringboot.vn.dto.InjectionCalendarDTO;
import com.laptrinhspringboot.vn.dto.other.InjectCalendarDTO;
import com.laptrinhspringboot.vn.entity.InjectionRegistration;
import com.laptrinhspringboot.vn.payload.response.ResponseInjectCalendar;
import com.laptrinhspringboot.vn.repositories.InjectionCalendarRepository;
import com.laptrinhspringboot.vn.repositories.InjectionRegistrationRepository;
import com.laptrinhspringboot.vn.service.iml.InjectionCalendarServiceImpl;
import com.laptrinhspringboot.vn.service.iml.InjectionRegistrationServiceImpl;

@RestController
@RequestMapping("/congthongtin")
@CrossOrigin("*")
public class InjectionRegistrationController {
	@Autowired
	private InjectionRegistrationServiceImpl  injectionRegistrationServiceImpl;
	@Autowired 
	private InjectionCalendarServiceImpl  injectionCalendarServiceImpl ;
	
	@GetMapping("/registerinjection")
	public ResponseEntity<ResponseInjectCalendar> registerInjection(
			@RequestParam(name = "customerid" ) Long ID ,
			@RequestParam(name = "today" ) String today ,
			@RequestParam(name = "district", required = false) String district,
			@RequestParam(name = "ward" ,required = false) String ward ,
			@RequestParam(name = "page" ,required = false) Integer page 
			) throws ParseException{
		 
		 Date date = Convert.stringToDate(today);
		
		 if(injectionRegistrationServiceImpl.checkRegistrationExpiredGreater( ID,date)  || 
				 injectionRegistrationServiceImpl.checkRegistrationExpiredEqual( ID,date) )
			 	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 
		 ResponseInjectCalendar reponsy = injectionCalendarServiceImpl
				 .getResponseInjectCalendar(ID, date, district, ward, page);
		 
		return new ResponseEntity<>(reponsy,HttpStatus.OK);
		//customerid=2&today=20/12/2000
//		 if(district == null && ward== null)
//		 {
//			 //lấy lịch sử tiêm gần nhất (done) 
//			  // list all lịch có thể đăng kí (where today ) (done)
//			 // list mui tiem 8 mui (done) 
//			 // list all district (done) 
//			 // list ward = null (done) 
//			 //  .
//			 //
//		 }
//		 else if(district!=null && ward !=null )
//		 {
//			
//			// list all lịch có thể đăng kí (where today , district ,ward  ) (done)
//			 // list  ward (where district) (done)
//			 
//		 }
//		 else if(district!=null &&ward ==null){
//			// list all lịch có thể đăng kí (where today , district ) (done) 
//			 // list  ward ( where district ) (done)
//		 }
//		
//		System.out.println(page);
				
		
	}
	
}
