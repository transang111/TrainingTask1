package com.example.sang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sang.dto.CertificateDTO;
import com.example.sang.entity.Certificate;
import com.example.sang.reponsitory.CertificateRepository;
import com.example.sang.service.CertificateService;

@Service
public class CertificateServiceIpm implements CertificateService {
	@Autowired
	private CertificateRepository certificateReponsitory;

	@Override
	public boolean createCertificate(CertificateDTO certificateDTO) {
		Certificate certificate = new Certificate();
		certificate.setName(certificateDTO.getName());
		if (certificateReponsitory.save(certificate) == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Certificate> getCertificates() {
		return certificateReponsitory.findAll();
	}

	@Override
	public void deleteCertificate(int id) {
		certificateReponsitory.deleteById(id);
	}

	@Override
	public void updateCertificate(CertificateDTO certificateDTO,int id) {
		Optional<Certificate> certificate = certificateReponsitory.findById(id);
		Certificate certificates=certificate.get();
		certificates.setName(certificateDTO.getName());
		certificateReponsitory.save(certificates);
	}

	@Override
	public Certificate getCertificatebyId(int id) {
		Optional<Certificate> certificate = certificateReponsitory.findById(id);
		Certificate certificates = certificate.get();
        return certificates;
	}

	@Override
	public void saveUSertoCertificate(Certificate certificate) {
		certificateReponsitory.save(certificate);
	}
}
