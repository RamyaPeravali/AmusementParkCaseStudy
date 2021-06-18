package com.capgemini.bankapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;





@Entity
@Table(name="cg_account")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Account {
	
	@NotNull(message="Account ID Is Mandatory")
	@Id
	@Column(name="acc_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acc_seq")
	@SequenceGenerator(sequenceName = "acc_seq", initialValue = 1 , allocationSize = 1, name = "acc_seq")
	private Integer accId;
	
	@NotEmpty(message="Customer Name Is Mandatory")
	@Size(min=3, max=25, message="Length can be 3 and 25 chars")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message="allow only alphabets and a blank scpace is allowed" )
	@Column(name="cust_name", length=25)
	private String custName;
	
	@NotNull(message="Balance Is Mandatory")
	@Min(value=1000, message="Your Opening amount must be Rs.1000")
	private Double balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer accId, String custName, Double balance) {
		super();
		this.accId = accId;
		this.custName = custName;
		this.balance = balance;
	}

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return accId + " "+   custName + " "+ balance ;
	}
	
}
