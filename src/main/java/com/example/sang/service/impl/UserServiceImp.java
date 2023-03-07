package com.example.sang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sang.dto.UserDTO;
import com.example.sang.entity.User;
import com.example.sang.reponsitory.UserRepository;
import com.example.sang.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository reponsitory;

	@Override
	public boolean createUser(UserDTO request) {
		User user = new User();
		user.setName(request.name);
		user.setAddress(request.address);
		user.setEmail(request.email);
		if (reponsitory.save(user) == null) {
			return false;
		}
		return true;
	}

	@Override
	public void updateUser(UserDTO UserDTO,int id) {
			Optional<User> users = reponsitory.findById(id);
			User user =users.get();
			user.setName(UserDTO.getName());
			user.setAddress(UserDTO.getAddress());
			user.setEmail(UserDTO.getEmail());
			reponsitory.save(user);
	}

	@Override
	public List<User> getUsers() {
		return reponsitory.findAll();
	}

	@Override
	public void deleteUser(int id) {
		reponsitory.deleteById(id);
	}

	@Override
	public User getUserbyId(int id) {
		Optional<User> user= reponsitory.findById(id);
		User users= user.get();
		 return users;
	}

	@Override
	public void saveCertificate(User user) {
		reponsitory.save(user);
	}

}
