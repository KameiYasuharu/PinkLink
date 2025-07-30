package com.example.demo.demos.web.dto;

import lombok.Data;

@Data
public class LoginResponse {
	private String state;
	private String errMsg;
	private String username;
	private String password;

}
