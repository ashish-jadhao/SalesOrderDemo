package com.assignment.salesorder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="addressId", strategy ="increment")
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(generator="addressId")
	private Integer addressId;
	
	@NotEmpty(message = "AddressLine1 must not be empty")
	private String addressLine1;
	private String addressLine2;
	
	//@NotEmpty(message = "pincode must not be empty")
	private Long pinCode;
	public Address(int i, String string, String string2, int j) {
		// TODO Auto-generated constructor stub
		this.addressId = i;
		this.addressLine1 = string;
		this.addressLine2 = string2;
		this.pinCode = (long) j;
	} 
	
	
	public Address() {
		super();
	}


	public Integer getAddressId() {
		return addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	
}
