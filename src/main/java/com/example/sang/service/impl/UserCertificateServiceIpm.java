package com.example.sang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sang.dto.Test;
import com.example.sang.dto.UserCertificateDTO;
import com.example.sang.reponsitory.UserCertificateRepository;
import com.example.sang.service.UserCertificateService;
@Service
public class UserCertificateServiceIpm implements UserCertificateService {
	@Autowired
	private UserCertificateRepository userCertificateRepository;

	@Override
	public List<UserCertificateDTO> findUserByDefQuerySQL() {
		List<Test> list = userCertificateRepository.findUserAndCertificate();
		List<UserCertificateDTO> liscerDto= new ArrayList<>();
		if(list!=null) {
			for (Test test : list) {
				UserCertificateDTO certificateDTO = new UserCertificateDTO();
			     certificateDTO.setId(test.getId());
			     certificateDTO.setName1(test.getName1());
			     certificateDTO.setName(test.getName());
			     liscerDto.add(certificateDTO);
			}
		}
		return liscerDto;
	}


	

}
