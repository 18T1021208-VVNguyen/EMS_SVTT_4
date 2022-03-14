package com.laptrinhspringboot.vn.service;

import java.util.List;

import com.laptrinhspringboot.vn.entity.UserGroup;

public interface IUserGroupService {
	List<UserGroup> findRole(String username);

}
