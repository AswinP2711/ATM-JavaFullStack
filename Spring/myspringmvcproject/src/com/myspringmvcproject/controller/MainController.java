package com.myspringmvcproject.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String showHome(Model model) {//Dependency Injection(DI)
		model.addAttribute("dateVal",LocalDate.now());
		return "home";
	}
	@RequestMapping("/products")
	public String showProducts(HttpServletRequest request) {
		request.setAttribute("dateVal", LocalDate.now());
		return "products";
	}
	@RequestMapping("/contact")
	public ModelAndView showContact(ModelAndView mav) {
		mav.addObject("dateVal",LocalDate.now());
		mav.setViewName("contact");
		return mav;
	}
	@RequestMapping("/about")
	public String showAbout() {
		return "about";
	}
}
