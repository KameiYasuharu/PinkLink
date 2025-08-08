package com.example.demo.demos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.demos.web.entity.PinDetail;
import com.example.demo.demos.web.service.PinDetailService;

@Controller
public class GetPinDetailController {

	@Autowired
	private PinDetailService pinDetailService;

	@GetMapping("/pinDetail")
	public String getPinDetail(@RequestParam String sbNo, Model model) {
		PinDetail detail = pinDetailService.findBySbNo(sbNo);
		if (detail == null) {
			model.addAttribute("error", "ピンが存在していない！");
			return "error";
		}
		model.addAttribute("detail", detail);
		return "pinDetailInfo";
	}

}
