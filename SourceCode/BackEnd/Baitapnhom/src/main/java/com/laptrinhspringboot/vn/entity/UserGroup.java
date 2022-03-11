package com.laptrinhspringboot.vn.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_group")
public class UserGroup extends Base {

	@Column(name = "administrator", columnDefinition = "bigint NOT NULL")
	private Long administrator;

	@Column(name = "name", columnDefinition = "varchar(50) NOT NULL")
	private String name;

	@ManyToMany(mappedBy = "userGroup")
	private List<User> getUsers = new ArrayList<User>();

	public Long getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Long administrator) {
		this.administrator = administrator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getGetUsers() {
		return getUsers;
	}

	public void setGetUsers(List<User> getUsers) {
		this.getUsers = getUsers;
	}

}
