package com.example.sang.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_certificate",
	joinColumns = @JoinColumn(name="certificate_id"),
	inverseJoinColumns = @JoinColumn(name="user_id "))
	private Set<User> listuser;
    
	
	public Set<User> getListuser() {
		return listuser;
	}

	public void setListuser(Set<User> listuser) {
		this.listuser = listuser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
