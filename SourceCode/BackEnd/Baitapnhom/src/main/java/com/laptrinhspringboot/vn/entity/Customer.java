package com.laptrinhspringboot.vn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends Base {

	@Column(name = "code", columnDefinition = "VARCHAR(255) NOT NULL", unique = true)
	private String code;

	@Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL")
	private String name;

	@Column(name = "birthday", columnDefinition = "DATETIME NOT NULL")
	private String birthday;

	@Column(name = "gender", columnDefinition = "BIT NOT NULL")
	private Long gender;

	@Column(name = "phone_number", columnDefinition = "VARCHAR(255) NOT NULL")
	private String phoneNumber;

	@Column(name = "email", columnDefinition = "VARCHAR(255) NOT NULL")
	private String email;

	@Column(name = "identification", columnDefinition = "VARCHAR(255) NOT NULL")
	private String identification;

	@Column(name = "health_insurance_number", columnDefinition = "VARCHAR(255) NOT NULL")
	private String healthInsuranceNumber;

	@Column(name = "occupation", columnDefinition = "VARCHAR(255) NOT NULL")
	private String occupation;

	@Column(name = "ethnic", columnDefinition = "VARCHAR(255) NOT NULL")
	private String ethnic;

	@Column(name = "address", columnDefinition = "VARCHAR(255) NOT NULL")
	private String address;

//	@OneToOne(mappedBy = "customer")
//    private User user;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<InjectionHistory> injectionHistory;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<InjectionRegistration> injectionRegistrations;

	public Customer(String code, String name, String birthday, Long gender, String phoneNumber, String email,
			String identification, String healthInsuranceNumber, String occupation, String ethnic, String address) {
		super();
		this.code = code;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.identification = identification;
		this.healthInsuranceNumber = healthInsuranceNumber;
		this.occupation = occupation;
		this.ethnic = ethnic;
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getHealthInsuranceNumber() {
		return healthInsuranceNumber;
	}

	public void setHealthInsuranceNumber(String healthInsuranceNumber) {
		this.healthInsuranceNumber = healthInsuranceNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
