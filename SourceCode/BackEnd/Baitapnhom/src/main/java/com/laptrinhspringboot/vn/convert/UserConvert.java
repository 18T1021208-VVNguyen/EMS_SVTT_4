package com.laptrinhspringboot.vn.convert;

import org.springframework.stereotype.Component;

import com.laptrinhspringboot.vn.dto.UserDTO;
import com.laptrinhspringboot.vn.entity.User;

@Component
public class UserConvert {

	public UserDTO toUserDto(User user) {
		UserDTO userDTO = new UserDTO();
		if (user.getId() != null) {
			userDTO.setId(user.getId());
		}
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setDeleted(user.getDeleted());
		userDTO.setCreatedUserId(user.getCreatedUserId());
		userDTO.setCreatedAt(user.getCreatedAt());
		userDTO.setModifiedAt(user.getModifiedAt());
		userDTO.setModifiedUserId(user.getModifiedUserId());
		return userDTO;
	}

}
