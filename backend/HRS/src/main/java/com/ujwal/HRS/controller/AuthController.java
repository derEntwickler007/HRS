package com.ujwal.HRS.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.HRS.dao.AuthDao;
import com.ujwal.HRS.entity.User;

import javassist.NotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hrs")
public class AuthController {
	
	@Autowired
	AuthDao authDao;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) throws NotFoundException {
		User user = null;
		try {
			user=authDao.getAuthentication(username,password);
			return ResponseEntity.ok(user);
		}catch(NoResultException|EmptyResultDataAccessException e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}