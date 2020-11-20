package com.ujwal.HRS.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ujwal.HRS.entity.User;
import com.ujwal.HRS.repository.UserRepository;

@Repository
@Transactional
@Scope("prototype")
public class UserDao {

	@Autowired
	UserRepository repository;
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public Optional<User> getUser(Integer id) {
		return repository.findById(id);
	}
	
	public void deleteUser(Integer id) {
		repository.deleteById(id);;
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}
	
}
