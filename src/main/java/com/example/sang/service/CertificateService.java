package com.example.sang.service;

import java.util.List;

import com.example.sang.dto.CertificateDTO;
import com.example.sang.entity.Certificate;

public interface CertificateService {
	List<Certificate> getCertificates();
	boolean createCertificate(CertificateDTO certificateDTO);
	
	void deleteCertificate(int id);
	void updateCertificate(CertificateDTO certificateDTO,int id);
	Certificate getCertificatebyId(int id);
	
	void saveUSertoCertificate(Certificate certificate);
}
