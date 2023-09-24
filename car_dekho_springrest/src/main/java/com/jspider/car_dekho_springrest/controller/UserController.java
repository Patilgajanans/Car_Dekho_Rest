package com.jspider.car_dekho_springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.car_dekho_springrest.pojo.UserPOJO;
import com.jspider.car_dekho_springrest.response.UserResponse;
import com.jspider.car_dekho_springrest.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping(path = "/createAccount",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> createUser(@RequestBody UserPOJO user){
		
		UserPOJO pojo = service.createAccount(user);
		
		if (pojo != null) {
			return new ResponseEntity<UserResponse>(new UserResponse("Account Created Successfully !", user),HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<UserResponse>(new UserResponse("Not Created",null),HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/login",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> checkLogin(@RequestBody UserPOJO user) {
		UserPOJO pojo = service.login(user);
		if (pojo != null) {
			return new ResponseEntity<UserResponse>(new UserResponse("Login Successfully !", user),HttpStatus.FOUND);
		}
		return new ResponseEntity<UserResponse>(new UserResponse("Login Unsuccssfully", null),HttpStatus.BAD_REQUEST);
	}
}
