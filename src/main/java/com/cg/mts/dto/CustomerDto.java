package com.cg.mts.dto;

public class CustomerDto {
	private String username;
	private String password;
	private String mobileNumber;
	private String email;
	private String address;
	private String role = "Customer";
	private Integer userId;
	
	public CustomerDto() {
		super();
	}

	public CustomerDto(Integer userId) {
		super();
		this.userId = userId;
	}

	public CustomerDto(String username, String password, String mobileNumber, String email, String address, String role,
			Integer userId) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.role = role;
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}