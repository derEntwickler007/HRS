package com.ujwal.HRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujwal.HRS.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{

}
