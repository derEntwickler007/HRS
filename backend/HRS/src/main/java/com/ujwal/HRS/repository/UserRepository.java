package com.ujwal.HRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujwal.HRS.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
		
}