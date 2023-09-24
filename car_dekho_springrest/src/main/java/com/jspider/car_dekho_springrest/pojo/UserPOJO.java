package com.jspider.car_dekho_springrest.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserPOJO {
	
	@Id
	private String username;
	private String password;
}
