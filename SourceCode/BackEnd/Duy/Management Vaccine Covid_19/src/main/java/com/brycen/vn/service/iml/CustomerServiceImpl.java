package com.brycen.vn.service.iml;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.vn.dto.CustomerDTO;
import com.brycen.vn.dto.UserDTO;
import com.brycen.vn.dto.User_CustomerDTO;
import com.brycen.vn.entity.Customer;
import com.brycen.vn.entity.User;
import com.brycen.vn.entity.UserGroup;
import com.brycen.vn.repositories.CustomerRepository;
import com.brycen.vn.repositories.UserRepository;
import com.brycen.vn.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	private final static String TOKEN_HEADER = "authorization";

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;

	@Override
	public CustomerDTO getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id).get();
		CustomerDTO customerDTO = modelmapper.map(customer, CustomerDTO.class);
		return customerDTO;
	}

	@Override
	public boolean registerCustomer(User_CustomerDTO user_CustomerDTO) {
		if (user_CustomerDTO.getUsername() == null || user_CustomerDTO.getUsername().isEmpty() == true
				|| user_CustomerDTO.getPassword() == null || user_CustomerDTO.getPassword().isEmpty() == true ||

				user_CustomerDTO.getName() == null || user_CustomerDTO.getName().isEmpty() == true ||

				user_CustomerDTO.getGender() == null || user_CustomerDTO.getBirthday() == null
				|| user_CustomerDTO.getBirthday().isEmpty() == true || user_CustomerDTO.getPhoneNumber() == null
				|| user_CustomerDTO.getPhoneNumber().isEmpty() == true || user_CustomerDTO.getEmail() == null
				|| user_CustomerDTO.getEmail().isEmpty() == true || user_CustomerDTO.getIdentification() == null
				|| user_CustomerDTO.getIdentification().isEmpty() == true
				|| user_CustomerDTO.getHealthInsuranceNumber() == null
				|| user_CustomerDTO.getHealthInsuranceNumber().isEmpty() == true
				|| user_CustomerDTO.getOccupation() == null || user_CustomerDTO.getOccupation().isEmpty() == true
				|| user_CustomerDTO.getAddress() == null || user_CustomerDTO.getAddress().isEmpty() == true
				|| user_CustomerDTO.getEthnic() == null || user_CustomerDTO.getEthnic().isEmpty() == true) {
			return false;
		} else {
			if (user_CustomerDTO != null) {
				Customer customer1 = customerRepository.findByCustomer();
				CustomerDTO customerdto1 = modelmapper.map(customer1, CustomerDTO.class);

				CustomerDTO customerdto = new CustomerDTO();
				customerdto.setCode("KH" + (customerdto1.getId() + 1));
				customerdto.setName(user_CustomerDTO.getName());
				customerdto.setBirthday(user_CustomerDTO.getBirthday());
				customerdto.setGender(user_CustomerDTO.getGender());
				customerdto.setPhoneNumber(user_CustomerDTO.getPhoneNumber());
				customerdto.setEmail(user_CustomerDTO.getEmail());
				customerdto.setIdentification(user_CustomerDTO.getIdentification());
				customerdto.setHealthInsuranceNumber(user_CustomerDTO.getHealthInsuranceNumber());
				customerdto.setOccupation(user_CustomerDTO.getOccupation());
				customerdto.setEthnic(user_CustomerDTO.getEthnic());
				customerdto.setAddress(user_CustomerDTO.getAddress());

				Customer customer = new Customer(); // set vaof customerdto
				customer.setCode(customerdto.getCode());
				customer.setName(customerdto.getName());
				customer.setBirthday(customerdto.getBirthday());
				customer.setGender(customerdto.getGender());
				customer.setPhoneNumber(customerdto.getPhoneNumber());
				customer.setEmail(customerdto.getEmail());
				customer.setIdentification(customerdto.getIdentification());
				customer.setHealthInsuranceNumber(customerdto.getHealthInsuranceNumber());
				customer.setOccupation(customerdto.getOccupation());
				customer.setEthnic(customerdto.getEthnic());
				customer.setAddress(customerdto.getAddress());

				UserDTO userdto = new UserDTO(); // set vaof userdto
				userdto.setUsername(user_CustomerDTO.getUsername());
				userdto.setPassword(user_CustomerDTO.getPassword());

				User user = modelmapper.map(userdto, User.class);
//				user.setUsername(userdto.getUsername());
//				user.setPassword(userdto.getPassword());

				user.setCustomer(customer);

				UserGroup userGroup1 = new UserGroup(1L, "ROLE_USER");
				List<UserGroup> listUserGroups = new ArrayList<UserGroup>();
				listUserGroups.add(userGroup1);
				user.setUserGroup(listUserGroups); // hợp lí hơn thì để 1-n

				user = userRepository.save(user);

				return true;
			}
		}
		return false;

	}

	@Override
	public boolean getCustomerByIdentification(String identification) {
		Customer customer = customerRepository.findByIdentification(identification);
		CustomerDTO customerDTO = modelmapper.map(customer, CustomerDTO.class);
		if (customerDTO != null) {
			return true;
		}
		return false;
	}

}
