package com.example.sang.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sang.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
