package com.example.demo.demos.web.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo.demos.web.dto.LoginRequest;
import com.example.demo.demos.web.dto.LoginResponse;
import com.example.demo.demos.web.service.DesignDocPermissionService;

@Controller
public class LoginController {

	@Resource
	DesignDocPermissionService designDocPermissionService;

	@GetMapping("/login")
	@ResponseBody
	public ResponseEntity<?> login(@ModelAttribute LoginRequest request) {
		LoginResponse response = new LoginResponse();
		try {
			//HttpSession session = httpRequest.getSession();
			//session.setAttribute("username", request.getUsername());
			designDocPermissionService
					.saveDesignDocPermission(request.getUsername());
			response.setState("OK");
			response.setUsername(request.getUsername());
			response.setPassword(request.getPassword());
			return ResponseEntity.ok().body(response);

		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(response);
		}

	}
}
