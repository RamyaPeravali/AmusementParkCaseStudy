package com.cg.mts.entities;

import javax.persistence.*;

@Entity
public class Customer extends AbstractUser {

	private String role = "Customer";

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}