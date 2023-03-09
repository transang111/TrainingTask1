package com.example.sang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_certificate")
public class UserCertificate {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "certificate_id")
	private int certificate_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCertificate_id() {
		return certificate_id;
	}

	public void setCertificate_id(int certificate_id) {
		this.certificate_id = certificate_id;
	}

}
