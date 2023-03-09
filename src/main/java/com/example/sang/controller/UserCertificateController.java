package com.example.sang.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sang.dto.UserCertificateDTO;
import com.example.sang.entity.Certificate;
import com.example.sang.entity.User;
import com.example.sang.service.impl.CertificateServiceIpm;
import com.example.sang.service.impl.UserCertificateServiceIpm;
import com.example.sang.service.impl.UserServiceImp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class UserCertificateController {

	@Autowired
	private UserServiceImp userService;

	@Autowired
	private CertificateServiceIpm certificateService;
	
	@Autowired
	private UserCertificateServiceIpm userCertificateServiceIpm;

	@GetMapping("/addUserCertificate")
	public String registercertificatetoUSer(ModelMap modelMap) {
		List<User> users = userService.getUsers();
		List<Certificate> certificates = certificateService.getCertificates();
		modelMap.addAttribute("certificates", certificates);
		modelMap.addAttribute("users", users);
		return "addUserCertificate";
	};

	@PostMapping("/addUserCertificate")
	public String addUertoCertificate(@Valid HttpServletRequest request, ModelMap modelMap) {
		// lấy user và certificate theo id request lên
		Integer id = Integer.valueOf((String) request.getParameter("user_id"));
		Integer certificateId = Integer.valueOf((String) request.getParameter("certificate_id"));
		User user = userService.getUserbyId(id);
		Certificate certificate = certificateService.getCertificatebyId(certificateId);

		// lấy toàn bộ users trong database
		List<User> users = userService.getUsers();

		// lấy ra toàn bộ danh sách chứng chỉ của mỗi người
		Set<Certificate> listCertificate = user.getUserCertificate();
		listCertificate.add(certificate);
		user.setUserCertificate(listCertificate);
		userService.saveCertificate(user);

		List<Certificate> certificates = certificateService.getCertificates();

		modelMap.addAttribute("certificates", certificates);
		modelMap.addAttribute("users", users);
		return "addUserCertificate";

	}
	@GetMapping("/userandcertificatesql")
	  public String showAllUserandCertificateSQL(ModelMap modelMap) {
		  List<UserCertificateDTO> UserCertificateDTO= userCertificateServiceIpm.findUserByDefQuerySQL();
			  modelMap.addAttribute("UserCertificateDTO", UserCertificateDTO);
		  return "userandcertificatesql";
	  }
	

}
