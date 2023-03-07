package com.example.sang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sang.dto.UserDTO;
import com.example.sang.entity.User;
import com.example.sang.service.impl.UserServiceImp;

@Controller
public class UserController {
	@Autowired
	private UserServiceImp userService;
	
	@GetMapping("/RegisterUser")
	public String RegisterUser(ModelMap modelMap) {
		UserDTO userdto = new UserDTO();
		modelMap.addAttribute("register",userdto);
		return "RegisterUser";
	}

	@PostMapping("/save")
	public String CreateUser(UserDTO request) {
         boolean kiemtra=false;
         kiemtra=userService.createUser(request);
         if(kiemtra) {
        	 return "redirect:home";
         }
		 return "RegisterUser";
	}
	@GetMapping("/updateuser/{id}")
	public String UpdateUser(ModelMap modelMap, @PathVariable int id) {
		User user = userService.getUserbyId(id);
		modelMap.addAttribute("upadte",user);
		return "updateuser";
	}
	
	@PostMapping("/updateuserpost/{id}")
	public String UpdateUser(UserDTO UserDTO,@PathVariable int id,ModelMap modelMap) {
		userService.updateUser(UserDTO,id);
		List<User> list =userService.getUsers();
		modelMap.addAttribute("list", list);
		return "home";
	}
	
	@GetMapping("/home")
	public String HomePage(ModelMap modelMap) {
		List<User> list =userService.getUsers();
		modelMap.addAttribute("list", list);
		return "home";
			
	}
	@GetMapping("/delete/{id}")
	public String DeleteUser(@PathVariable(value = "id")int id,ModelMap modelMap) {
		userService.deleteUser(id);
		List<User> list =userService.getUsers();
		modelMap.addAttribute("list", list);
		return "home";
	}
	
}