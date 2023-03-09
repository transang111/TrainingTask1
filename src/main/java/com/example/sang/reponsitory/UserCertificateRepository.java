package com.example.sang.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sang.dto.Test;
import com.example.sang.entity.User;

@Repository
public interface UserCertificateRepository extends JpaRepository<User, Integer> {
	// @Query("SELECT user.id, user.name,certificate.name FROM user INNER JOIN
	// user_certificate ON user.id = user_certificate.user_id INNER JOIN certificate
	// ON certificate.id = user_certificate.certificate_id")
	/*
	 * @Query(value = "select * from user_certificate", nativeQuery = true)
	 * List<UserCertificate> findUserByDefQuery();
	 */
	@Query(value ="SELECT user.id, user.name as name1, certificate.name FROM user INNER JOIN user_certificate ON user.id = user_certificate.user_id INNER JOIN certificate ON certificate.id = user_certificate.certificate_id ", nativeQuery = true)
	List<Test> findUserAndCertificate();
}
