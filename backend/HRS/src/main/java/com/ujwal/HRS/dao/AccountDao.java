package com.ujwal.HRS.dao;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ujwal.HRS.entity.Account;
import com.ujwal.HRS.repository.AccountRepository;

@Repository
@Transactional
@Scope("prototype")
public class AccountDao {
	
	@Autowired
	private AccountRepository accountRepository;

	public Account save(Account account) throws SQLIntegrityConstraintViolationException {
		return accountRepository.save(account);
	}
	
	public Account getAccount(Long id) {
		return accountRepository.getOne(id);
	}
}
