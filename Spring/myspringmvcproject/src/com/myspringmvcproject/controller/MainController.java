package com.myspringmvcproject.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspringmvcproject.model.Product;
import com.myspringmvcproject.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String showHome(Model model) {//Dependency Injection(DI)
		model.addAttribute("dateVal",LocalDate.now());
		return "home";
	}
	@RequestMapping("/products")
	public String showProducts(HttpServletRequest request) {
		List<Product> list=productService.getAllProducts();
		request.setAttribute("productList", list);
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
