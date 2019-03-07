package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value="/")
	public String showHomePage() {
		return "index";
	}
	@RequestMapping(value="/home")
	public String showHomePage1() {
		return "index";
	}
	@RequestMapping(value="/login")
	public String showLoginPage() {
		return "Login";
	}
	@RequestMapping(value="/register")
	public String showRegisterPage() {
		return "Register";
	}
	@RequestMapping(value="/aboutus")
	public String showAboutusPage() {
		return "AboutUs";
	}
	@RequestMapping(value="/contactus")
	public String showContactusPage() {
		return "ContactUs";
	}
	
	
}