package com.phatbt027.XPhone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String root() {
		return "redirect:/index.html";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/user/index")
	public String userIndex() {
		return "user/index.html";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "security/register.html";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "security/login.html";
	}
}
