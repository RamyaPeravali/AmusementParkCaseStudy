package com.cg.mts.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends AbstractUser {

	private Integer adminId;
	private String role = "Admin";

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}