package com.example.sang.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sang.entity.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

}
