package com.example.sang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sang.dto.CertificateDTO;
import com.example.sang.entity.Certificate;
import com.example.sang.service.impl.CertificateServiceIpm;

@Controller
@RequestMapping("/certificate")
public class CertificateController {
	@Autowired
	private CertificateServiceIpm certificateServiceIpm;
	
	@GetMapping("/home")
	public String getCertuficates(ModelMap modelMap) {
		List<Certificate> listall= certificateServiceIpm.getCertificates();
		modelMap.addAttribute("listc", listall);
		return "certificatehome";
	}
	
	@GetMapping("/register")
	public String CreateCertificates(ModelMap modelMap) {
		CertificateDTO certificateDTO= new CertificateDTO();
		modelMap.addAttribute("certificateDTO", certificateDTO);
		return "register";
	}

	@PostMapping("/save")
	public String CreateCertificate(@ModelAttribute("certificateDTO") CertificateDTO certificateDTO, ModelMap modelMap) {
		boolean kt = certificateServiceIpm.createCertificate(certificateDTO);
		
		List<Certificate> CertificatedtoRequestData=certificateServiceIpm.getCertificates();
		for (Certificate certificatedata : CertificatedtoRequestData) {
			if(certificateDTO.getName().equals(certificatedata.getName())) {
				modelMap.addAttribute("mesageCertificate", "Chứng chỉ đã tôn tai");
				return "redirect:register";
			}
		}
		if (kt) {
			return "redirect:certificatehome";
		}
		return "register";
	}
	@GetMapping("/delete/{id}")
	public String DeleteCertificateService(@PathVariable int id, ModelMap modelMap) {
		certificateServiceIpm.deleteCertificate(id);
		List<Certificate> listall= certificateServiceIpm.getCertificates();
		modelMap.addAttribute("listc", listall);
		return "certificatehome";
	}
	@GetMapping("/update/{id}")
	public String updateCertificates(ModelMap modelMap,@PathVariable int id) {
		CertificateDTO certificateDTO= new CertificateDTO();
		modelMap.addAttribute("certificateDTO", certificateDTO);
		Certificate certificate= certificateServiceIpm.getCertificatebyId(id);
		modelMap.addAttribute("certificateDTO", certificate);
		return "updatecerficate";
	}
	@PostMapping("/updatecertificate/{id}")
	public String updateCertificate(@ModelAttribute("certificateDTO") CertificateDTO certificateDTO, ModelMap modelMap, @PathVariable int id) {
		 certificateServiceIpm.updateCertificate(certificateDTO,id);
		 List<Certificate> listall= certificateServiceIpm.getCertificates();
		 modelMap.addAttribute("listc", listall);
		 
		  return "certificatehome";
	}
}
