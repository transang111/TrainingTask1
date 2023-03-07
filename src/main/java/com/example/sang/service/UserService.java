package com.example.sang.service;

import java.util.List;

import com.example.sang.dto.UserDTO;
import com.example.sang.entity.User;

public interface UserService {
	boolean createUser(UserDTO request);

	void updateUser(UserDTO UserDTO,int id);

	List<User> getUsers();

	void deleteUser(int id);
	
	User getUserbyId(int id);
	
	void saveCertificate(User user);

}