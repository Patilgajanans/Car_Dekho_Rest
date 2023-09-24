package com.jspider.car_dekho_springrest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspider.car_dekho_springrest.pojo.UserPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
	
	private String msg;
	private UserPOJO user;

}
