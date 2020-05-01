package com.assignment.salesorder.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="custId", strategy ="increment")
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(generator="custId")
	private Integer customerId;
	
	@NotEmpty(message = "first name must not be empty")
	private String name;
	
	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be a valid email")
	private String emailId;
	
	// one customer has one address
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;

	
	public Customer() {
		super();
	}

	public Customer(int i, String string, String string2, Address address2) {
		// TODO Auto-generated constructor stub
		this.customerId = i;
		this.name = string;
		this.emailId = string2;
		this.address = address2;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * @Override public String toString() { return "Customer [customerId=" +
	 * customerId + ", name=" + name + ", emailId=" + emailId + ", address=" +
	 * address + "]"; }
	 */
	
	
	
}
