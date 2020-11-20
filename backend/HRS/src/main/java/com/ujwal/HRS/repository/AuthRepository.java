package com.ujwal.HRS.repository;

import com.ujwal.HRS.entity.User;

public interface AuthRepository{
	 
	public User getAuthentication(String userName, String password);
	
}
