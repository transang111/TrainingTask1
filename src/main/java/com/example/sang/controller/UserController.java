package com.example.sang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sang.dto.UserDTO;
import com.example.sang.entity.User;
import com.example.sang.service.impl.UserServiceImp;

import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserServiceImp userService;

	@GetMapping("/RegisterUser")
	public String RegisterUser(ModelMap modelMap) {
		UserDTO userdto = new UserDTO();
		modelMap.addAttribute("userDTO", userdto);
		return "RegisterUser";
	}

	@PostMapping("/save")
	public String CreateUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult,
			ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			return "RegisterUser";
		}
		;
		boolean kiemtra = false;

		UserDTO userrequest = userDTO;
		List<User> listuserRequestData = userService.getUsers();
		for (User users : listuserRequestData) {
			if (userrequest.getName().equals(users.getName())) {
				modelMap.addAttribute("messeges", "Tên đã tôn tại");
				return "RegisterUser";
			}
		}
		kiemtra = userService.createUser(userDTO);
		if (kiemtra) {
			return "redirect:home";
		}

		return "RegisterUser";
	}

	@GetMapping("/updateuser/{id}")
	public String UpdateUser(ModelMap modelMap, @PathVariable int id) {
		User user = userService.getUserbyId(id);
		modelMap.addAttribute("upadte", user);
		return "updateuser";
	}

	@PostMapping("/updateuserpost/{id}")
	public String UpdateUser(@ModelAttribute("UserDTO") UserDTO UserDTO, @PathVariable int id, ModelMap modelMap) {
		userService.updateUser(UserDTO, id);
		List<User> list = userService.getUsers();
		modelMap.addAttribute("list", list);
		return "home";
	}

	@GetMapping("/home")
	public String HomePage(ModelMap modelMap) {
		List<User> list = userService.getUsers();
		modelMap.addAttribute("list", list);
		return "home";

	}

	@GetMapping("/delete/{id}")
	public String DeleteUser(@PathVariable(value = "id") int id, ModelMap modelMap) {
		userService.deleteUser(id);
		List<User> list = userService.getUsers();
		modelMap.addAttribute("list", list);
		return "home";
	}

}