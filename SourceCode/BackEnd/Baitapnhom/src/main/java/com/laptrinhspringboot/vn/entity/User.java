package com.laptrinhspringboot.vn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User extends Base {

	@Column(name = "username", columnDefinition = "varchar(30) NOT NULL")
	private String username;

	@Column(name = "password", columnDefinition = "varchar(30) NOT NULL")
	private String password;

	@ManyToMany
	@JoinTable(name = "user_group_relation", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_group_id"))
	private List<UserGroup> userGroup = new ArrayList<UserGroup>();

//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserGroup> getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(List<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}

}
