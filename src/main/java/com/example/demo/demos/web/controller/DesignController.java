package com.example.demo.demos.web.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.demos.web.dto.DesignRequest;
import com.example.demo.demos.web.dto.SelectDesignDoc;
import com.example.demo.demos.web.service.DesignDocService;

@Controller
public class DesignController {

	@Resource
	DesignDocService designService;

	@GetMapping("/design")
	public ResponseEntity<?> design(@ModelAttribute DesignRequest request) {
		SelectDesignDoc selectDesignDoc = new SelectDesignDoc();
		try {
			//HttpSession session = httpRequest.getSession();
			//String username = (String) session.getAttribute("username");

			selectDesignDoc = designService
					.selectDesignDoc(request.getSekkeishobangou(),request.getUsername());
			return ResponseEntity.ok().body(selectDesignDoc);

		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(selectDesignDoc);
		}

	}
}
