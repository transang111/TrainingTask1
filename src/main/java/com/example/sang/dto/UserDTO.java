package com.example.sang.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDTO {
	
	@NotEmpty(message = "Tên không được bỏ trông")
	public String name;
	
	@NotEmpty(message = "Địa chỉ không được bỏ trông")
	public String address;
	
	@Email(regexp = "^[a-zA-Z0-9_\\.]{1,}@[a-z0-9\\.]{2,}$", message = "Email Không Hợp Lệ")
	public String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}