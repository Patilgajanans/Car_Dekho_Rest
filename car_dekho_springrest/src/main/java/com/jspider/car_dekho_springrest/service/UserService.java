package com.jspider.car_dekho_springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.car_dekho_springrest.pojo.UserPOJO;
import com.jspider.car_dekho_springrest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public UserPOJO createAccount(UserPOJO user) {
		UserPOJO pojo = repository.createAccount(user);
		return pojo;
	}

	public UserPOJO login(UserPOJO user) {
		UserPOJO pojo = repository.login(user);
		return pojo;
	}

}
