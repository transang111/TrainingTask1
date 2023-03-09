package com.example.sang.service;

import java.util.List;

import com.example.sang.dto.UserCertificateDTO;

public interface UserCertificateService {
	List<UserCertificateDTO> findUserByDefQuerySQL();
}
