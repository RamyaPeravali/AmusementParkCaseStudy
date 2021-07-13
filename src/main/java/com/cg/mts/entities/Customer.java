package com.cg.mts.entities;

import javax.persistence.*;

@Entity
public class Customer extends AbstractUser {

	private Integer customerId;
	private String role = "Customer";

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}