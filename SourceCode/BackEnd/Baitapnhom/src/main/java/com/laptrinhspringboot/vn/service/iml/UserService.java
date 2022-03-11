package com.laptrinhspringboot.vn.service.iml;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhspringboot.vn.convert.UserConvert;
import com.laptrinhspringboot.vn.dto.UserDTO;
import com.laptrinhspringboot.vn.entity.User;
import com.laptrinhspringboot.vn.repositories.UserRepository;
import com.laptrinhspringboot.vn.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserConvert userConvert;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean checkLogin(String username, String password) {
		User userMySql = userRepository.findByUsernameAndPassword(username, password);
		if (userMySql != null) {
			return true;
		}
		return false;
	}

	@Override
	public User loadUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<UserDTO> getAll() {

		List<User> listUser = userRepository.findAll();
		List<UserDTO> listDto = listUser.stream().map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return listDto;
	}

	@Override
	public UserDTO findByid(Long id) {
		// TODO Auto-generated method stub

		User user = userRepository.findById(id).get();

		UserDTO userDto = modelMapper.map(user, UserDTO.class);

		return userDto;
	}

}
