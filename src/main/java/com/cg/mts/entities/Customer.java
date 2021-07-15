package com.cg.mts.entities;

import javax.persistence.*;

@Entity
public class Customer extends AbstractUser {

	private String role = "customer";

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}