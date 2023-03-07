package com.example.sang.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sang.entity.Certificate;
import com.example.sang.entity.User;
import com.example.sang.service.impl.CertificateServiceIpm;
import com.example.sang.service.impl.UserServiceImp;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserCertificateController {
    
	@Autowired
	private UserServiceImp userService;
	
	@Autowired
	private CertificateServiceIpm certificateService;
	
	@GetMapping("/addUserCertificate")
	public String registercertificatetoUSer(ModelMap modelMap) {
		List<User> users= userService.getUsers();
		List<Certificate> certificates= certificateService.getCertificates();
		modelMap.addAttribute("certificates", certificates);
		modelMap.addAttribute("users", users);
		return "addUserCertificate";
	};
	@PostMapping("/addUserCertificate")
	public String addUertoCertificate(HttpServletRequest request,ModelMap modelMap) {
		Integer id = Integer.valueOf((String )request.getParameter("user_id"));
		Integer certificateId = Integer.valueOf((String )request.getParameter("certificate_id"));
		
		User user= userService.getUserbyId(id);
		Certificate certificate= certificateService.getCertificatebyId(certificateId);
		
		Set<Certificate> listCertificate= user.getUserCertificate();
		
		listCertificate.add(certificate);
		
		user.setUserCertificate(listCertificate);
		
		
		userService.saveCertificate(user);
		
		List<User> users= userService.getUsers();
		List<Certificate> certificates= certificateService.getCertificates();
		modelMap.addAttribute("certificates", certificates);
		modelMap.addAttribute("users", users);
		return "addUserCertificate";
	}
	
	
}
